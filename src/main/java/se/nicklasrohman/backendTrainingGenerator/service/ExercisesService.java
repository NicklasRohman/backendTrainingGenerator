package se.nicklasrohman.backendTrainingGenerator.service;


import org.springframework.http.ResponseEntity;
import se.nicklasrohman.backendTrainingGenerator.dto.ExerciseDto;
import se.nicklasrohman.backendTrainingGenerator.service.entity.ExercisesEntity;

import java.util.List;

public interface ExercisesService {

    List<ExercisesEntity> getAllExercises();

    ResponseEntity<ExerciseDto> getExercisesById(int id);

    ResponseEntity<Object> addExercise(ExerciseDto exerciseDto);

    ResponseEntity<Object> updateExercise(ExerciseDto exerciseDto);

    ResponseEntity<Object> deleteExercise(int id);
}
