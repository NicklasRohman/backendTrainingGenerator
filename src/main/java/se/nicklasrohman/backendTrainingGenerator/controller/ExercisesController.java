package se.nicklasrohman.backendTrainingGenerator.controller;

import org.json.JSONException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.nicklasrohman.backendTrainingGenerator.dto.ExerciseDto;

public interface ExercisesController {

    @GetMapping("/exercises")
    ResponseEntity<Object> getAllExercises() throws JSONException;

    @GetMapping("/exercises/{id}")
    ResponseEntity<ExerciseDto> getExerciseById(int id);

    @PostMapping("/exercises")
    ResponseEntity<Object> addNewExercise(@RequestBody ExerciseDto exerciseDto);

    @PutMapping("/exercises{id}")
    ResponseEntity<Object> updateExercise();

    @DeleteMapping("/exercises/{id}")
    ResponseEntity<Object> deleteExercise(int id);

}
