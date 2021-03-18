package se.nicklasrohman.backendTrainingGenerator.repository.init;

import org.springframework.stereotype.Repository;
import se.nicklasrohman.backendTrainingGenerator.entity.Exercises;
import se.nicklasrohman.backendTrainingGenerator.repository.ExercisesRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ExercisesRepositoryInit implements ExercisesRepository {

    @Override
    public List<Exercises> getAllExercises() {

        Exercises exercises = new Exercises();
        exercises.setExercise_id(1);
        exercises.setExercise_name("name");
        exercises.setDifficult_level(5);
        exercises.setEstimated_time(10.5);
        exercises.setVideoPath("videoPath");

        List<Exercises> listOfExercises = new ArrayList<>();
        listOfExercises.add(exercises);

        return listOfExercises;
    }

}
