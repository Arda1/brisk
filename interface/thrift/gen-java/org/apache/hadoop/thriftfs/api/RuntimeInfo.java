/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package org.apache.hadoop.thriftfs.api;

import org.apache.commons.lang.builder.HashCodeBuilder;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Memory available via java.lang.Runtime
 */
public class RuntimeInfo implements org.apache.thrift.TBase<RuntimeInfo, RuntimeInfo._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("RuntimeInfo");

  private static final org.apache.thrift.protocol.TField TOTAL_MEMORY_FIELD_DESC = new org.apache.thrift.protocol.TField("totalMemory", org.apache.thrift.protocol.TType.I64, (short)1);
  private static final org.apache.thrift.protocol.TField FREE_MEMORY_FIELD_DESC = new org.apache.thrift.protocol.TField("freeMemory", org.apache.thrift.protocol.TType.I64, (short)2);
  private static final org.apache.thrift.protocol.TField MAX_MEMORY_FIELD_DESC = new org.apache.thrift.protocol.TField("maxMemory", org.apache.thrift.protocol.TType.I64, (short)3);

  public long totalMemory;
  public long freeMemory;
  public long maxMemory;

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TOTAL_MEMORY((short)1, "totalMemory"),
    FREE_MEMORY((short)2, "freeMemory"),
    MAX_MEMORY((short)3, "maxMemory");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // TOTAL_MEMORY
          return TOTAL_MEMORY;
        case 2: // FREE_MEMORY
          return FREE_MEMORY;
        case 3: // MAX_MEMORY
          return MAX_MEMORY;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __TOTALMEMORY_ISSET_ID = 0;
  private static final int __FREEMEMORY_ISSET_ID = 1;
  private static final int __MAXMEMORY_ISSET_ID = 2;
  private BitSet __isset_bit_vector = new BitSet(3);

  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TOTAL_MEMORY, new org.apache.thrift.meta_data.FieldMetaData("totalMemory", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.FREE_MEMORY, new org.apache.thrift.meta_data.FieldMetaData("freeMemory", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.MAX_MEMORY, new org.apache.thrift.meta_data.FieldMetaData("maxMemory", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(RuntimeInfo.class, metaDataMap);
  }

  public RuntimeInfo() {
  }

  public RuntimeInfo(
    long totalMemory,
    long freeMemory,
    long maxMemory)
  {
    this();
    this.totalMemory = totalMemory;
    setTotalMemoryIsSet(true);
    this.freeMemory = freeMemory;
    setFreeMemoryIsSet(true);
    this.maxMemory = maxMemory;
    setMaxMemoryIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public RuntimeInfo(RuntimeInfo other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    this.totalMemory = other.totalMemory;
    this.freeMemory = other.freeMemory;
    this.maxMemory = other.maxMemory;
  }

  public RuntimeInfo deepCopy() {
    return new RuntimeInfo(this);
  }

  @Override
  public void clear() {
    setTotalMemoryIsSet(false);
    this.totalMemory = 0;
    setFreeMemoryIsSet(false);
    this.freeMemory = 0;
    setMaxMemoryIsSet(false);
    this.maxMemory = 0;
  }

  public long getTotalMemory() {
    return this.totalMemory;
  }

  public RuntimeInfo setTotalMemory(long totalMemory) {
    this.totalMemory = totalMemory;
    setTotalMemoryIsSet(true);
    return this;
  }

  public void unsetTotalMemory() {
    __isset_bit_vector.clear(__TOTALMEMORY_ISSET_ID);
  }

  /** Returns true if field totalMemory is set (has been assigned a value) and false otherwise */
  public boolean isSetTotalMemory() {
    return __isset_bit_vector.get(__TOTALMEMORY_ISSET_ID);
  }

  public void setTotalMemoryIsSet(boolean value) {
    __isset_bit_vector.set(__TOTALMEMORY_ISSET_ID, value);
  }

  public long getFreeMemory() {
    return this.freeMemory;
  }

  public RuntimeInfo setFreeMemory(long freeMemory) {
    this.freeMemory = freeMemory;
    setFreeMemoryIsSet(true);
    return this;
  }

  public void unsetFreeMemory() {
    __isset_bit_vector.clear(__FREEMEMORY_ISSET_ID);
  }

  /** Returns true if field freeMemory is set (has been assigned a value) and false otherwise */
  public boolean isSetFreeMemory() {
    return __isset_bit_vector.get(__FREEMEMORY_ISSET_ID);
  }

  public void setFreeMemoryIsSet(boolean value) {
    __isset_bit_vector.set(__FREEMEMORY_ISSET_ID, value);
  }

  public long getMaxMemory() {
    return this.maxMemory;
  }

  public RuntimeInfo setMaxMemory(long maxMemory) {
    this.maxMemory = maxMemory;
    setMaxMemoryIsSet(true);
    return this;
  }

  public void unsetMaxMemory() {
    __isset_bit_vector.clear(__MAXMEMORY_ISSET_ID);
  }

  /** Returns true if field maxMemory is set (has been assigned a value) and false otherwise */
  public boolean isSetMaxMemory() {
    return __isset_bit_vector.get(__MAXMEMORY_ISSET_ID);
  }

  public void setMaxMemoryIsSet(boolean value) {
    __isset_bit_vector.set(__MAXMEMORY_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case TOTAL_MEMORY:
      if (value == null) {
        unsetTotalMemory();
      } else {
        setTotalMemory((Long)value);
      }
      break;

    case FREE_MEMORY:
      if (value == null) {
        unsetFreeMemory();
      } else {
        setFreeMemory((Long)value);
      }
      break;

    case MAX_MEMORY:
      if (value == null) {
        unsetMaxMemory();
      } else {
        setMaxMemory((Long)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case TOTAL_MEMORY:
      return new Long(getTotalMemory());

    case FREE_MEMORY:
      return new Long(getFreeMemory());

    case MAX_MEMORY:
      return new Long(getMaxMemory());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case TOTAL_MEMORY:
      return isSetTotalMemory();
    case FREE_MEMORY:
      return isSetFreeMemory();
    case MAX_MEMORY:
      return isSetMaxMemory();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof RuntimeInfo)
      return this.equals((RuntimeInfo)that);
    return false;
  }

  public boolean equals(RuntimeInfo that) {
    if (that == null)
      return false;

    boolean this_present_totalMemory = true;
    boolean that_present_totalMemory = true;
    if (this_present_totalMemory || that_present_totalMemory) {
      if (!(this_present_totalMemory && that_present_totalMemory))
        return false;
      if (this.totalMemory != that.totalMemory)
        return false;
    }

    boolean this_present_freeMemory = true;
    boolean that_present_freeMemory = true;
    if (this_present_freeMemory || that_present_freeMemory) {
      if (!(this_present_freeMemory && that_present_freeMemory))
        return false;
      if (this.freeMemory != that.freeMemory)
        return false;
    }

    boolean this_present_maxMemory = true;
    boolean that_present_maxMemory = true;
    if (this_present_maxMemory || that_present_maxMemory) {
      if (!(this_present_maxMemory && that_present_maxMemory))
        return false;
      if (this.maxMemory != that.maxMemory)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_totalMemory = true;
    builder.append(present_totalMemory);
    if (present_totalMemory)
      builder.append(totalMemory);

    boolean present_freeMemory = true;
    builder.append(present_freeMemory);
    if (present_freeMemory)
      builder.append(freeMemory);

    boolean present_maxMemory = true;
    builder.append(present_maxMemory);
    if (present_maxMemory)
      builder.append(maxMemory);

    return builder.toHashCode();
  }

  public int compareTo(RuntimeInfo other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    RuntimeInfo typedOther = (RuntimeInfo)other;

    lastComparison = Boolean.valueOf(isSetTotalMemory()).compareTo(typedOther.isSetTotalMemory());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTotalMemory()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.totalMemory, typedOther.totalMemory);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetFreeMemory()).compareTo(typedOther.isSetFreeMemory());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFreeMemory()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.freeMemory, typedOther.freeMemory);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMaxMemory()).compareTo(typedOther.isSetMaxMemory());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMaxMemory()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.maxMemory, typedOther.maxMemory);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    org.apache.thrift.protocol.TField field;
    iprot.readStructBegin();
    while (true)
    {
      field = iprot.readFieldBegin();
      if (field.type == org.apache.thrift.protocol.TType.STOP) { 
        break;
      }
      switch (field.id) {
        case 1: // TOTAL_MEMORY
          if (field.type == org.apache.thrift.protocol.TType.I64) {
            this.totalMemory = iprot.readI64();
            setTotalMemoryIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // FREE_MEMORY
          if (field.type == org.apache.thrift.protocol.TType.I64) {
            this.freeMemory = iprot.readI64();
            setFreeMemoryIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // MAX_MEMORY
          if (field.type == org.apache.thrift.protocol.TType.I64) {
            this.maxMemory = iprot.readI64();
            setMaxMemoryIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        default:
          org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
      }
      iprot.readFieldEnd();
    }
    iprot.readStructEnd();

    // check for required fields of primitive type, which can't be checked in the validate method
    validate();
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    oprot.writeFieldBegin(TOTAL_MEMORY_FIELD_DESC);
    oprot.writeI64(this.totalMemory);
    oprot.writeFieldEnd();
    oprot.writeFieldBegin(FREE_MEMORY_FIELD_DESC);
    oprot.writeI64(this.freeMemory);
    oprot.writeFieldEnd();
    oprot.writeFieldBegin(MAX_MEMORY_FIELD_DESC);
    oprot.writeI64(this.maxMemory);
    oprot.writeFieldEnd();
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("RuntimeInfo(");
    boolean first = true;

    sb.append("totalMemory:");
    sb.append(this.totalMemory);
    first = false;
    if (!first) sb.append(", ");
    sb.append("freeMemory:");
    sb.append(this.freeMemory);
    first = false;
    if (!first) sb.append(", ");
    sb.append("maxMemory:");
    sb.append(this.maxMemory);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bit_vector = new BitSet(1);
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

}

