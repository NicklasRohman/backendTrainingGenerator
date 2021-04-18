--liquibase formatted sql

--changeset nicklas.rohman:1 logicalFilePath:0.sql
--comment: adding training table
CREATE TABLE IF NOT EXISTS training_database.training(
    exercise_id int UNSIGNED AUTO_INCREMENT NOT NULL,
    exercise_name varchar(255) NOT NULL,
    difficult_level int(10) NOT NULL DEFAULT 1,
    estimated_time double NOT NULL DEFAULT 1,
    video_path varchar(255) DEFAULT "",
    description varchar(500) DEFAULT "",
    PRIMARY KEY (exercise_id)
)
engine=innodb;

--changeset nicklas.rohman:2 logicalFilePath:0.sql
--comment: adding category table
CREATE TABLE IF NOT EXISTS training_database.category(
    id int UNSIGNED  NOT NULL,
    exercise_id int UNSIGNED NOT NULL,
    category_name varchar(255) NOT NULL,
    CONSTRAINT FK_CategoryTraining FOREIGN KEY (exercise_id) REFERENCES training(exercise_id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
)
engine=innodb;

--changeset nicklas.rohman:3 logicalFilePath:0.sql
--comment: adding style table
CREATE TABLE IF NOT EXISTS training_database.style(
    id int UNSIGNED  NOT NULL,
    exercise_id int UNSIGNED NOT NULL,
    style_name varchar(255) NOT NULL,
    CONSTRAINT FK_StyleTraining FOREIGN KEY (exercise_id) REFERENCES training(exercise_id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
)
engine=innodb;

--changeset nicklas.rohman:4 logicalFilePath:0.sql
--comment: adding image table
CREATE TABLE IF NOT EXISTS training_database.image(
    id int UNSIGNED NOT NULL,
    exercise_id int UNSIGNED NOT NULL,
    image_name varchar(255) NOT NULL,
    CONSTRAINT FK_ImageTraining FOREIGN KEY (exercise_id) REFERENCES training(exercise_id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
)
engine=innodb;