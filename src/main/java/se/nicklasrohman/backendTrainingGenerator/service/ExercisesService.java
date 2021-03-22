package se.nicklasrohman.backendTrainingGenerator.service;


import org.springframework.http.ResponseEntity;
import se.nicklasrohman.backendTrainingGenerator.dto.ExerciseDto;
import se.nicklasrohman.backendTrainingGenerator.service.entity.ExercisesEntity;

import java.util.List;

public interface ExercisesService {

    List<ExercisesEntity> getAllExercises();

    ResponseEntity<ExerciseDto> getExercisesById(int id);

    void addExercise(ExerciseDto exerciseDto);

    void updateExercise(ExerciseDto exerciseDto);

    void deleteExercise(int id);
}
