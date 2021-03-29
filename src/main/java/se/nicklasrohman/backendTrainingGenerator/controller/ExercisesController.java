package se.nicklasrohman.backendTrainingGenerator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.nicklasrohman.backendTrainingGenerator.entity.ExercisesEntity;

import java.util.List;

@RequestMapping("/exercise")
public interface ExercisesController {

    @GetMapping("/all")
    ResponseEntity<Object> getAllExercises();

    @GetMapping("/{id}")
    ResponseEntity<ExercisesEntity> getExerciseById(@PathVariable int id);

    @GetMapping("/search/{exerciseName}")
    ResponseEntity<List<ExercisesEntity>> getExerciseByName(@PathVariable String exerciseName);

    @PostMapping("/create")
    ResponseEntity<Object> createNewExercise(@RequestBody ExercisesEntity exercisesEntity);

    @PutMapping("/update/{id}")
    ResponseEntity<Object> updateExercise(
            @PathVariable int id,
            @RequestBody ExercisesEntity exercisesEntity);

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Object> deleteExercise(@PathVariable int id);

    @GetMapping("/random/")
    ResponseEntity<Object> getRandomExercises(
            @RequestParam int numberOfExercises,
            @RequestParam int minDifficulty,
            @RequestParam int maxDifficulty,
            @RequestParam double minEstimatedTime,
            @RequestParam double maxEstimatedTime);
}
