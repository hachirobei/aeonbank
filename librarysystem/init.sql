CREATE DATABASE IF NOT EXISTS librarysystem;

CREATE USER IF NOT EXISTS 'test'@'%' IDENTIFIED WITH mysql_native_password BY 'test';

GRANT ALL PRIVILEGES ON librarysystem.* TO 'test'@'%';

FLUSH PRIVILEGES;