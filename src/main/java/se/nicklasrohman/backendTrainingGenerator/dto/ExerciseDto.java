package se.nicklasrohman.backendTrainingGenerator.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ExerciseDto {
    int id;
    String exerciseName;
    int difficultLevel;
    double estimatedTime;
    String videoPath;
    String description;
}
