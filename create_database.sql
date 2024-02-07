# create databases
use mysql;
CREATE DATABASE IF NOT EXISTS `devdb` CHARACTER SET utf8 COLLATE utf8_persian_ci;
CREATE USER 'demo'@'%' IDENTIFIED BY 'demo';
GRANT ALL ON devdb.* TO 'demo'@'%';