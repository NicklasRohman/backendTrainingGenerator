package se.nicklasrohman.backendTrainingGenerator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.nicklasrohman.backendTrainingGenerator.dto.ExerciseDto;

public interface ExercisesController {

    @GetMapping("/exercises")
    ResponseEntity<Object> getAllExercises();

    @GetMapping("/exercise/{id}")
    ResponseEntity<ExerciseDto> getExerciseById(int id);

    @PostMapping("/exercise")
    ResponseEntity<Object> addNewExercise(@RequestBody ExerciseDto exerciseDto);

    @PutMapping("/exercise{id}")
    ResponseEntity<Object> updateExercise(@RequestBody ExerciseDto exerciseDto);

    @DeleteMapping("/exercise/{id}")
    ResponseEntity<Object> deleteExercise(int id);

}
