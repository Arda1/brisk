package org.apache.cassandra.hadoop.hive.metastore;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.apache.cassandra.CleanupHelper;
import org.apache.cassandra.EmbeddedServer;
import org.apache.cassandra.config.ConfigurationException;
import org.apache.cassandra.config.DatabaseDescriptor;
import org.apache.cassandra.hadoop.CassandraProxyClient;
import org.apache.cassandra.thrift.Cassandra;
import org.apache.cassandra.thrift.CfDef;
import org.apache.cassandra.thrift.KsDef;
import org.apache.cassandra.thrift.NotFoundException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.metastore.api.Database;
import org.apache.hadoop.hive.metastore.api.Table;
import org.apache.thrift.transport.TTransportException;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MetaStorePersisterTest extends CleanupHelper
{

    private MetaStorePersister metaStorePersister;
    private CassandraClientHolder clientHolder;
    
    @BeforeClass
    public static void setup() throws TTransportException, IOException, InterruptedException, ConfigurationException
    {
        EmbeddedServer.startBrisk();                
    }
    
    @Before
    public void setupClient() throws Exception 
    {
        Configuration conf = buildConfiguration();
        clientHolder = new CassandraClientHolder(conf);        
        
        CfDef cf = new CfDef(clientHolder.getKeyspaceName(), clientHolder.getColumnFamily());
        KsDef ks = new KsDef(clientHolder.getKeyspaceName(), "org.apache.cassandra.locator.SimpleStrategy", 1, Arrays.asList(cf));
        
        clientHolder.getClient().system_add_keyspace(ks);        
        
        metaStorePersister = new MetaStorePersister(conf);
    }
    
    @Test
    public void testBasicPersistMetaStoreEntity() 
    {
        Database database = new Database();
        database.setName("name");
        database.setDescription("description");
        database.setLocationUri("uri");
        database.setParameters(new HashMap<String, String>());
        metaStorePersister.save(database.metaDataMap, database, database.getName()); // save(TBase base).. via _Fields and findByThriftId, publi MetaDataMap
    }
    
    @Test(expected=NotFoundException.class)
    public void testEntityNotFound() throws Exception
    {
        Database database = new Database();
        database.setName("foo");
        metaStorePersister.load(database, "name");
    }
    
    @Test
    public void testBasicLoadMetaStoreEntity() throws Exception 
    {
        Database database = new Database();
        database.setName("name");
        database.setDescription("description");
        database.setLocationUri("uri");
        database.setParameters(new HashMap<String, String>());
        metaStorePersister.save(database.metaDataMap, database, database.getName());
        Database foundDb = new Database();
        metaStorePersister.load(foundDb, "name");
        assertEquals(database, foundDb);
    }
    
    @Test
    public void testFindMetaStoreEntities() 
    {
        Database database = new Database();
        database.setName("dbname");
        database.setDescription("description");
        database.setLocationUri("uri");
        database.setParameters(new HashMap<String, String>());
        metaStorePersister.save(database.metaDataMap, database, database.getName());
        Table table = new Table();
        table.setDbName("dbname");
        table.setTableName("table_one");
        metaStorePersister.save(table.metaDataMap, table, table.getDbName());
        table.setTableName("table_two");
        metaStorePersister.save(table.metaDataMap, table, table.getDbName());
        table.setTableName("table_three");
        metaStorePersister.save(table.metaDataMap, table, table.getDbName());
        table.setTableName("other_table");
        metaStorePersister.save(table.metaDataMap, table, table.getDbName());
        
        List tables = metaStorePersister.find(table, "dbname");
        assertEquals(4, tables.size());
        tables = metaStorePersister.find(table, "dbname", "table", 100);
        assertEquals(3, tables.size());
    }
    
    @Test
    public void testEntityDeletion() throws Exception 
    {
        Database database = new Database();
        database.setName("name");
        database.setDescription("description");
        database.setLocationUri("uri");
        database.setParameters(new HashMap<String, String>());
        metaStorePersister.save(database.metaDataMap, database, database.getName());
        
        Database foundDb = new Database();
        metaStorePersister.load(foundDb, "name");
        assertEquals(database, foundDb);
        metaStorePersister.remove(foundDb, "name");
        try {
            metaStorePersister.load(foundDb, "name");
            fail();
        } 
        catch (NotFoundException e) 
        {
            // win! \o/
        }
    }
    
    @After
    public void teardownClient() throws Exception 
    {
        clientHolder.getClient().system_drop_keyspace("HiveMetaStore");
    }
    
    private Configuration buildConfiguration() 
    {
        Configuration conf = new Configuration();
        conf.set(CassandraClientHolder.CONF_PARAM_HOST, "localhost");
        conf.setInt(CassandraClientHolder.CONF_PARAM_PORT, DatabaseDescriptor.getRpcPort());
        conf.setBoolean(CassandraClientHolder.CONF_PARAM_FRAMED, true);
        conf.setBoolean(CassandraClientHolder.CONF_PARAM_RANDOMIZE_CONNECTIONS, true);
        return conf;
    }
}
