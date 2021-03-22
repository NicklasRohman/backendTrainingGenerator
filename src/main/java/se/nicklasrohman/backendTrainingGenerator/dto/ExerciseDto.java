package se.nicklasrohman.backendTrainingGenerator.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
@RequiredArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ExerciseDto {

    String exerciseName;
    int difficultLevel;
    BigDecimal estimatedTime;
    String videoPath;
}
