package se.nicklasrohman.backendTrainingGenerator.controller.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import se.nicklasrohman.backendTrainingGenerator.controller.ExercisesController;
import se.nicklasrohman.backendTrainingGenerator.entity.ExercisesEntity;
import se.nicklasrohman.backendTrainingGenerator.entity.RandomExercisesEntityCriteria;
import se.nicklasrohman.backendTrainingGenerator.service.ExercisesService;

import java.util.List;

@RestController
public class ExercisesControllerInit implements ExercisesController {

    @Autowired
    ExercisesService exercisesService;

    @Override
    public ResponseEntity<Object> getAllExercises() {

        try{
            List<ExercisesEntity> exercisesEntityList = exercisesService.getAllExercises();
        if (exercisesEntityList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
            return new ResponseEntity<>(exercisesEntityList, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ExercisesEntity> getExerciseById(@PathVariable int id) {
        return exercisesService.getExercisesById(id);
    }

    @Override
    public ResponseEntity<List<ExercisesEntity>> getExerciseByName(@PathVariable String exerciseName) {

        return exercisesService.getExercisesByName(exerciseName);

    }

    @Override
    public ResponseEntity<Object> createNewExercise(
            @RequestBody ExercisesEntity exercisesEntity) {

        return exercisesService.createExercise(exercisesEntity);
    }

    @Override
    public ResponseEntity<Object> updateExercise(
            @PathVariable int id,
            @RequestBody ExercisesEntity exercisesEntity) {

        return exercisesService.updateExercise(id, exercisesEntity);

    }

    @Override
    public ResponseEntity<Object> deleteExercise(@PathVariable int id) {
        return exercisesService.deleteExercise(id);
    }

    @Override
    public ResponseEntity<Object> getRandomExercises(int numberOfExercises, int minDifficulty, int maxDifficulty, double minEstimatedTime, double maxEstimatedTime) {
        if (numberOfExercises <= 0) {
            return new ResponseEntity<>("Number of exercises must be more then 0",HttpStatus.NOT_ACCEPTABLE);
        }
        else if (numberOfExercises >= 100) {
            return new ResponseEntity<>("Number of exercises must be less then 100",HttpStatus.NOT_ACCEPTABLE);
        }

        RandomExercisesEntityCriteria randomExercisesEntityCriteria = new RandomExercisesEntityCriteria();
        randomExercisesEntityCriteria.setNumberOfExercises(numberOfExercises);
        randomExercisesEntityCriteria.setMinDifficulty(minDifficulty);
        randomExercisesEntityCriteria.setMaxDifficulty(maxDifficulty);
        randomExercisesEntityCriteria.setMinEstimatedTime(minEstimatedTime);
        randomExercisesEntityCriteria.setMaxEstimatedTim(maxEstimatedTime);

        List<ExercisesEntity> exercisesEntityList = exercisesService.getRandomExercises(randomExercisesEntityCriteria);

        if (exercisesEntityList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(exercisesEntityList, HttpStatus.OK);
    }

}