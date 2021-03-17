package se.nicklasrohman.backendTrainingGenerator.repository;


import se.nicklasrohman.backendTrainingGenerator.controller.init.Exercises;

import java.util.List;

public interface ExercisesRepository {

    List<Exercises> getAllExercises();
}
