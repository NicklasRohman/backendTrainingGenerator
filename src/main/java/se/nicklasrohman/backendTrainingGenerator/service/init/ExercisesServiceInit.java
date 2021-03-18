package se.nicklasrohman.backendTrainingGenerator.service.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.nicklasrohman.backendTrainingGenerator.entity.Exercises;
import se.nicklasrohman.backendTrainingGenerator.repository.ExercisesRepository;
import se.nicklasrohman.backendTrainingGenerator.service.ExercisesService;

import java.util.List;


@Service
public class ExercisesServiceInit implements ExercisesService {

    @Autowired
    ExercisesRepository exercisesRepository;

    @Override
    public List<Exercises> getAllExercises() {

        return exercisesRepository.findAll();
    }

}
