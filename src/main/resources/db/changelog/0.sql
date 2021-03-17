--liquibase formatted sql

--changeset nicklas.rohman:1 logicalFilePath:0.sql
--comment: adding training table
CREATE TABLE training_database.training(
    id int UNSIGNED AUTO_INCREMENT NOT NULL,
    exercise_name varchar(255) NOT NULL,
    image_path varchar(255),
    video_path varchar(255),
    PRIMARY KEY (id)
)

--changeset nicklas.rohman:2 logicalFilePath:0.sql
--comment: adding training table
CREATE TABLE training_database.category(
    id int UNSIGNED AUTO_INCREMENT NOT NULL,
    category_name varchar(255) NOT NULL,
    PRIMARY KEY (id)
)

--changeset nicklas.rohman:3 logicalFilePath:0.sql
--comment: adding training table
CREATE TABLE training_database.tag(
    id int UNSIGNED AUTO_INCREMENT NOT NULL,
    tag_name varchar(255) NOT NULL,
    PRIMARY KEY (id)
)