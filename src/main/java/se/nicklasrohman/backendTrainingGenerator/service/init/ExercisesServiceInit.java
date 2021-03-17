package se.nicklasrohman.backendTrainingGenerator.service.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.nicklasrohman.backendTrainingGenerator.controller.init.Exercises;
import se.nicklasrohman.backendTrainingGenerator.repository.ExercisesRepository;
import se.nicklasrohman.backendTrainingGenerator.service.ExercisesService;

import java.util.List;


@Service
public class ExercisesServiceInit implements ExercisesService {

    @Autowired
    ExercisesRepository exercisesRepository;


    @Override
    public List<Exercises> getAllExercises() {

        List<Exercises> allExercises = exercisesRepository.getAllExercises();

        return allExercises;
    }

}
