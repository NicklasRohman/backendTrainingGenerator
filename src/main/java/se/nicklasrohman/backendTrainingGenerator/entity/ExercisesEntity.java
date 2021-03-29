package se.nicklasrohman.backendTrainingGenerator.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "training")
public class ExercisesEntity {

    @Id
    @Column(name = "exercise_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int exerciseId;

    @Column(name = "exercise_name")
    String exerciseName;

    @Column(name = "difficult_level")
    int difficultLevel;

    @Column(name = "estimated_time")
    double estimatedTime;

    @Column(name = "video_path")
    String videoPath;

}
