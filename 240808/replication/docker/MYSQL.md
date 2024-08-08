# MySQL

Docker 환경에서 동작하는 MySQL의 환경설정 파일입니다.
경로는 `/etc` 에 존재합니다.

파일의 기본 내용은 아래와 같습니다.

```text
# For advice on how to change settings please see
# http://dev.mysql.com/doc/refman/9.0/en/server-configuration-defaults.html

[mysqld]
#
# Remove leading # and set to the amount of RAM for the most important data
# cache in MySQL. Start at 70% of total RAM for dedicated server, else 10%.
# innodb_buffer_pool_size = 128M
#
# Remove leading # to turn on a very important data integrity option: logging
# changes to the binary log between backups.
# log_bin
#
# Remove leading # to set options mainly useful for reporting servers.
# The server defaults are faster for transactions and fast SELECTs.
# Adjust sizes as needed, experiment to find the optimal values.
# join_buffer_size = 128M
# sort_buffer_size = 2M
# read_rnd_buffer_size = 2M

host-cache-size=0
skip-name-resolve
datadir=/var/lib/mysql
socket=/var/run/mysqld/mysqld.sock
secure-file-priv=/var/lib/mysql-files
user=mysql

pid-file=/var/run/mysqld/mysqld.pid
[client]
socket=/var/run/mysqld/mysqld.sock

!includedir /etc/mysql/conf.d/
```

## Ref

- [Docker를 이용하여 MySQL Replication 구성해보기](https://jupiny.com/2017/11/07/docker-mysql-replicaiton/)
- [MySQL 분산처리(Replication with docker)](https://velog.io/@hyunho058/Mysql-%EB%B6%84%EC%82%B0%EC%B2%98%EB%A6%ACReplication-with-docker)