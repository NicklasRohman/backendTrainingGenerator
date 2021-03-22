package se.nicklasrohman.backendTrainingGenerator.service;


import se.nicklasrohman.backendTrainingGenerator.service.entity.ExercisesEntity;

import java.util.List;

public interface ExercisesService {

    List<ExercisesEntity> getAllExercises();
}
