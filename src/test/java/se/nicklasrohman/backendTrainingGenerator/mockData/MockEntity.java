package se.nicklasrohman.backendTrainingGenerator.mockData;

import se.nicklasrohman.backendTrainingGenerator.entity.ExercisesEntity;

import java.util.ArrayList;
import java.util.List;

public class MockEntity {

    public static ExercisesEntity createMockExercisesEntity(Integer difficultLevel,Double estimatedTime) {

        ExercisesEntity exercisesEntity = new ExercisesEntity();
        exercisesEntity.setExerciseId(1);
        exercisesEntity.setDifficultLevel(difficultLevel);
        exercisesEntity.setExerciseName("test");
        exercisesEntity.setVideoPath("test");
        exercisesEntity.setDescription("test");
        exercisesEntity.setEstimatedTime(estimatedTime);

        return exercisesEntity;
    }

    public static List<ExercisesEntity> mockExercisesEntity(Integer numberOfGames, Integer difficultLevel, Double estimatedTime){

        List<ExercisesEntity> result = new ArrayList<>();
        for (int i = 0; i < numberOfGames; i++) {

            result.add(createMockExercisesEntity(difficultLevel, estimatedTime));
        }
        return result;
    }

}
