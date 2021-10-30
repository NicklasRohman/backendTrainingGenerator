--liquibase formatted sql

--changeset nicklas.rohman:1 logicalFilePath:2.sql
--comment: adding drop category table
DROP TABLE category;
engine=innodb;