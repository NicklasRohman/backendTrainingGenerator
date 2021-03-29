package se.nicklasrohman.backendTrainingGenerator.service;


import org.springframework.http.ResponseEntity;
import se.nicklasrohman.backendTrainingGenerator.entity.ExercisesEntity;
import se.nicklasrohman.backendTrainingGenerator.entity.RandomExercisesEntityCriteria;

import java.util.List;

public interface ExercisesService {

    List<ExercisesEntity> getAllExercises();

    ResponseEntity<ExercisesEntity> getExercisesById(int id);

    ResponseEntity<Object> createExercise(ExercisesEntity exercisesEntity);

    ResponseEntity<Object> updateExercise(int id, ExercisesEntity exercisesEntity);

    ResponseEntity<Object> deleteExercise(int id);

    ResponseEntity<List<ExercisesEntity>> getExercisesByName(String exerciseName);

    List<ExercisesEntity> getRandomExercises(RandomExercisesEntityCriteria randomExercisesEntityCriteria);
}
