%global username cassandra

%define relname %{name}-%{version}
%define hive_name hive-%{version}
%define briskname brisk

Name:           brisk-libhive
Version:        0.7.0
Release:        1
Summary:        Repackaging of Apache Hive libraries for inclusion in Brisk

Group:          Development/Libraries
License:        Apache Software License
URL:            http://hive.apache.org/
Source0:        brisk-src.tar.gz
BuildRoot:      %{_tmppath}/%{relname}-root-%(%{__id_u} -n)

BuildRequires: java-devel
BuildRequires: jpackage-utils
BuildRequires: ant
BuildRequires: ant-nodeps

Requires:      java >= 1.6.0
Requires:      jpackage-utils
Requires(pre): user(cassandra)
Requires(pre): group(cassandra)
Requires(pre): shadow-utils
Provides:      user(cassandra)
Provides:      group(cassandra)

BuildArch:      noarch

%description
Realtime analytics and distributed database (cassandra libraries)
Brisk is a realtime analytics system marrying the distributed database
Cassandra and the mapreduce system Hadoop together.

This package contains the Brisk Hive libraries.

Homepage: http://www.datastax.com/products/brisk

%prep
# tmp hack for now, until we figure out a src target
%setup -q -n brisk
#%setup -q -n %{relname}-src

%build
ant clean jar -Drelease=true

%install
%{__rm} -rf %{buildroot}
mkdir -p %{buildroot}%{_sysconfdir}/hive/
mkdir -p %{buildroot}/usr/share/%{briskname}/hive/lib
mkdir -p %{buildroot}/etc/%{briskname}/hive/default.conf
mkdir -p %{buildroot}/usr/bin

# copy over configurations and libs
cp -p resources/hive/conf/* %{buildroot}/etc/%{briskname}/hive/default.conf
cp -p resources/hive/lib/*.jar %{buildroot}/usr/share/%{briskname}/hive/lib
# copy the hive binary
cp -p resources/hive/bin/hive %{buildroot}/usr/bin

%clean
%{__rm} -rf %{buildroot}

# still just the user cassandra for now if it does not exist
%pre
getent group %{username} >/dev/null || groupadd -r %{username}
getent passwd %{username} >/dev/null || \
useradd -d /usr/share/%{briskname}/%{username} -g %{username} -M -r %{username}
exit 0

%files
%defattr(-,root,root,0755)
# do we need a %doc task?
%attr(755,root,root) %{_bindir}/*
%attr(755,%{username},%{username}) %config(noreplace) /%{_sysconfdir}/%{briskname}/hive

# chown on brisk as cassandra is our only user for now
%attr(755,%{username},%{username}) /usr/share/%{briskname}*

%post
alternatives --install /etc/%{briskname}/hive/conf %{username} /etc/%{briskname}/hive/default.conf/ 0
exit 0

%postun
# only delete alternative on removal, not upgrade
if [ "$1" = "0" ]; then
    alternatives --remove %{username} /etc/%{briskname}/hive/default.conf/
fi
exit 0
