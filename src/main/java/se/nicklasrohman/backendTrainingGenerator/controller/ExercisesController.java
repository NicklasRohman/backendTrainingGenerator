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
    ResponseEntity<Object> addNewExercise(
            @RequestParam("exerciseName") String exerciseName,
            @RequestParam("difficultLevel") int difficultLevel,
            @RequestParam("estimatedTime") double estimatedTime,
            @RequestParam("videoPath") String videoPath);

    @PutMapping("/exercise/{id}")
    ResponseEntity<Object> updateExercise(
            @PathVariable int id,
            @RequestParam("exerciseName") String exerciseName,
            @RequestParam("difficultLevel") int difficultLevel,
            @RequestParam("estimatedTime") double estimatedTime,
            @RequestParam("videoPath") String videoPath

    );


    @DeleteMapping("/exercise/{id}")
    ResponseEntity<Object> deleteExercise(@PathVariable int id);

}
