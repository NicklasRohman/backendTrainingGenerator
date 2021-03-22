package se.nicklasrohman.backendTrainingGenerator.controller.init;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import se.nicklasrohman.backendTrainingGenerator.controller.ExercisesController;
import se.nicklasrohman.backendTrainingGenerator.service.ExercisesService;
import se.nicklasrohman.backendTrainingGenerator.service.entity.ExercisesEntity;

import java.util.List;

@RestController
public class ExercisesControllerInit implements ExercisesController {

    @Autowired
    ExercisesService exercisesService;

    @Override
    public ResponseEntity<Object> getAllExercises() throws JSONException {
        List<ExercisesEntity> test = exercisesService.getAllExercises();

        return new ResponseEntity<>(test, HttpStatus.OK);
    }

    @Override
    public void getExerciseById() {
    }

    @Override
    public void addNewExercise() {
    }

    @Override
    public void updateExercise() {
    }

    @Override
    public void deleteExercise() {
    }

}