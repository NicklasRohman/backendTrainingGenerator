package se.nicklasrohman.backendTrainingGenerator.controller.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import se.nicklasrohman.backendTrainingGenerator.controller.ExercisesController;
import se.nicklasrohman.backendTrainingGenerator.entity.Exercises;
import se.nicklasrohman.backendTrainingGenerator.service.ExercisesService;

import java.util.List;

@RestController
public class ExercisesControllerInit implements ExercisesController {

    @Autowired
    ExercisesService exercisesService;

    public ExercisesControllerInit(ExercisesService exercisesService) {
        this.exercisesService = exercisesService;
    }

    @Override
    @GetMapping("/exercises")
    public List<Exercises> getAllExercises() {

        List<Exercises> allExercises = exercisesService.getAllExercises();

        return allExercises;
    }

}
