--liquibase formatted sql

--changeset nicklas.rohman:1 logicalFilePath:tags.sql
--comment: adding tags table
CREATE TABLE IF NOT EXISTS training_database.tags(
    tag_id int UNSIGNED AUTO_INCREMENT NOT NULL,
    tag_name varchar(255) NOT NULL,
    PRIMARY KEY (tag_id)
)
engine=innodb;

--changeset nicklas.rohman:1 logicalFilePath:tags.sql
--comment: adding exercise_tags table
CREATE TABLE IF NOT EXISTS training_database.exercise_tags(
    exercise_id int NOT NULL,
    tag_id int NOT NULL,
    )
engine=innodb;