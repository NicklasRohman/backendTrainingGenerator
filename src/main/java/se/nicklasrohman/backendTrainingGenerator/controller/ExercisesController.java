package se.nicklasrohman.backendTrainingGenerator.controller;

import org.json.JSONException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

public interface ExercisesController {

    @GetMapping("/exercises")
    ResponseEntity<Object> getAllExercises() throws JSONException;

    @GetMapping("/exercises/{id}")
    void getExerciseById();

    @PostMapping("/exercises")
    void addNewExercise();

    @PutMapping("/exercises{id}")
    void updateExercise();

    @DeleteMapping("/exercises/{id}")
    void deleteExercise();

}
