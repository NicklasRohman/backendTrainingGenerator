package se.nicklasrohman.backendTrainingGenerator.controller.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import se.nicklasrohman.backendTrainingGenerator.controller.ExercisesController;
import se.nicklasrohman.backendTrainingGenerator.dto.ExerciseDto;
import se.nicklasrohman.backendTrainingGenerator.service.ExercisesService;
import se.nicklasrohman.backendTrainingGenerator.service.entity.ExercisesEntity;

import java.util.List;

@RestController
public class ExercisesControllerInit implements ExercisesController {

    @Autowired
    ExercisesService exercisesService;

    @Override
    public ResponseEntity<Object> getAllExercises() {
        List<ExercisesEntity> exercisesEntityList = exercisesService.getAllExercises();

        return new ResponseEntity<>(exercisesEntityList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ExerciseDto> getExerciseById(@PathVariable int id) {
        return exercisesService.getExercisesById(id);
    }

    @Override
    public ResponseEntity<Object> addNewExercise(
            @RequestParam("exerciseName") String exerciseName,
            @RequestParam("difficultLevel") int difficultLevel,
            @RequestParam("estimatedTime") double estimatedTime,
            @RequestParam("videoPath") String videoPath) {

        ExerciseDto exerciseDto = new ExerciseDto();
        exerciseDto.setExerciseName(exerciseName);
        exerciseDto.setDifficultLevel(difficultLevel);
        exerciseDto.setEstimatedTime(estimatedTime);
        exerciseDto.setVideoPath(videoPath);

        return exercisesService.addExercise(exerciseDto);
    }

    @Override
    public ResponseEntity<Object> updateExercise(
            @PathVariable("id") int id,
            @RequestParam("exerciseName") String exerciseName,
            @RequestParam("difficultLevel") int difficultLevel,
            @RequestParam("estimatedTime") double estimatedTime,
            @RequestParam("videoPath") String videoPath) {

        ExerciseDto exerciseDto = new ExerciseDto();
        exerciseDto.setId(id);
        exerciseDto.setExerciseName(exerciseName);
        exerciseDto.setDifficultLevel(difficultLevel);
        exerciseDto.setEstimatedTime(estimatedTime);
        exerciseDto.setVideoPath(videoPath);

        return exercisesService.updateExercise(exerciseDto);
    }

    @Override
    public ResponseEntity<Object> deleteExercise(@PathVariable int id) {
        return exercisesService.deleteExercise(id);
    }

}