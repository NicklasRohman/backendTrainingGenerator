package se.nicklasrohman.backendTrainingGenerator.entity;

import lombok.Data;

@Data
public class RandomExercisesEntityCriteria {

    int numberOfExercises;
    int minDifficulty;
    int maxDifficulty;
    double minEstimatedTime;
    double maxEstimatedTim;

}
