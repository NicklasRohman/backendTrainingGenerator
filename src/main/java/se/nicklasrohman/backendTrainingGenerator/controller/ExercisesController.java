package se.nicklasrohman.backendTrainingGenerator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.nicklasrohman.backendTrainingGenerator.dto.ExerciseDto;

@RequestMapping("/exercise")
public interface ExercisesController {

    @GetMapping("/all")
    ResponseEntity<Object> getAllExercises();

    @GetMapping("/{id}")
    ResponseEntity<ExerciseDto> getExerciseById(int id);

    @PostMapping("/create")
    ResponseEntity<Object> addNewExercise(
            @RequestParam("exerciseName") String exerciseName,
            @RequestParam("difficultLevel") int difficultLevel,
            @RequestParam("estimatedTime") double estimatedTime,
            @RequestParam("videoPath") String videoPath);

    @PutMapping("/update/{id}")
    ResponseEntity<Object> updateExercise(
            @PathVariable int id,
            @RequestParam("exerciseName") String exerciseName,
            @RequestParam("difficultLevel") int difficultLevel,
            @RequestParam("estimatedTime") double estimatedTime,
            @RequestParam("videoPath") String videoPath);

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Object> deleteExercise(@PathVariable int id);

}
