package se.nicklasrohman.backendTrainingGenerator.entity;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Exercises {

    int exercise_id;
    String exercise_name;
    int difficult_level;
    double estimated_time;
    String videoPath;

}
