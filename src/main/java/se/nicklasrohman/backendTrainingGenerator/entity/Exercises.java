package se.nicklasrohman.backendTrainingGenerator.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Exercises {

    @Id
    int exerciseId;
    String exerciseName;
    int difficultLevel;
    double estimatedTime;
    String videoPath;

}
