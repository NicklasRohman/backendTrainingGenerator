package se.nicklasrohman.backendTrainingGenerator.repository.init;

import org.springframework.stereotype.Repository;
import se.nicklasrohman.backendTrainingGenerator.controller.init.Exercises;
import se.nicklasrohman.backendTrainingGenerator.repository.ExercisesRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ExercisesRepositoryInit implements ExercisesRepository {

    @Override
    public List<Exercises> getAllExercises() {

        Exercises exercises = new Exercises();
        exercises.setId(1);
        exercises.setName("name");
        exercises.setImagePath("imagePath");
        exercises.setVideoPath("videoPath");

        List<Exercises> listOfExercises = new ArrayList<>();
        listOfExercises.add(exercises);

        return listOfExercises;
    }

}
