package se.nicklasrohman.backendTrainingGenerator.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

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
    @Min(1)
    @Max(10)
    int difficultLevel;

    @Column(name = "estimated_time")
    @DecimalMin(value = "0.1", message = "Min value is 0.1")
    @DecimalMax(value = "10", message = "Max value is 10")
    double estimatedTime;

    @Column(name = "video_path")
    String videoPath;

    @Column(name = "description")
    String description;

    @ManyToMany
    List<TagsEntity> tagsEntityList;
}
