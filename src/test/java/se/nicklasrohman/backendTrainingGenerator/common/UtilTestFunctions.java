package se.nicklasrohman.backendTrainingGenerator.common;

import se.nicklasrohman.backendTrainingGenerator.dto.ExerciseDto;
import se.nicklasrohman.backendTrainingGenerator.service.entity.ExercisesEntity;

public class UtilTestFunctions {

    public static ExercisesEntity createExerciseEntity(){
        ExercisesEntity exercisesEntity = new ExercisesEntity();
        exercisesEntity.setExerciseId(1);
        exercisesEntity.setExerciseName("Test");
        exercisesEntity.setDifficultLevel(1);
        exercisesEntity.setEstimatedTime(1.0);
        exercisesEntity.setVideoPath("");

        return exercisesEntity;
    }

    public static ExerciseDto createExerciseDto(){
        ExerciseDto exerciseDto = new ExerciseDto();
        exerciseDto.setId(1);
        exerciseDto.setExerciseName("test");
        exerciseDto.setVideoPath("");
        exerciseDto.setEstimatedTime(1);
        exerciseDto.setDifficultLevel(1);

        return exerciseDto;
    }

    public static ExerciseDto convertEntityToDto(ExercisesEntity exercisesEntity){

        ExerciseDto exerciseDto = new ExerciseDto();
        exerciseDto.setId(exercisesEntity.getExerciseId());
        exerciseDto.setExerciseName(exercisesEntity.getExerciseName());
        exerciseDto.setDifficultLevel(exercisesEntity.getDifficultLevel());
        exerciseDto.setEstimatedTime(exercisesEntity.getEstimatedTime());
        exerciseDto.setVideoPath(exercisesEntity.getVideoPath());

        return exerciseDto;
    }

    public static ExercisesEntity concertDtoToEntity(ExerciseDto exerciseDto){

        ExercisesEntity exercisesEntity = new ExercisesEntity();
        exercisesEntity.setExerciseId(exerciseDto.getId());
        exercisesEntity.setExerciseName(exerciseDto.getExerciseName());
        exercisesEntity.setDifficultLevel(exerciseDto.getDifficultLevel());
        exercisesEntity.setEstimatedTime(exerciseDto.getEstimatedTime());
        exercisesEntity.setVideoPath(exerciseDto.getVideoPath());

        return exercisesEntity;
    }

}
