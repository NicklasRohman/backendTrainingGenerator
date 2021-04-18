package se.nicklasrohman.backendTrainingGenerator.mockData;

import se.nicklasrohman.backendTrainingGenerator.entity.ExercisesEntity;

public class MockEntity {

    public static ExercisesEntity createMockExercisesEntity() {

        ExercisesEntity exercisesEntity = new ExercisesEntity();
        exercisesEntity.setExerciseId(1);
        exercisesEntity.setDifficultLevel(1);
        exercisesEntity.setExerciseName("test");
        exercisesEntity.setVideoPath("test");
        exercisesEntity.setDescription("test");
        exercisesEntity.setEstimatedTime(1.1);

        return exercisesEntity;
    }

}
