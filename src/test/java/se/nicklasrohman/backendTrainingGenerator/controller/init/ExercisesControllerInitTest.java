package se.nicklasrohman.backendTrainingGenerator.controller.init;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import se.nicklasrohman.backendTrainingGenerator.common.UtilTestFunctions;
import se.nicklasrohman.backendTrainingGenerator.dto.ExerciseDto;
import se.nicklasrohman.backendTrainingGenerator.service.ExercisesService;
import se.nicklasrohman.backendTrainingGenerator.service.entity.ExercisesEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class ExercisesControllerInitTest {
    @Mock
    ExercisesService exercisesService;
    @InjectMocks
    ExercisesControllerInit exercisesControllerInit;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllExercises() {

        ExercisesEntity exercisesEntity = UtilTestFunctions.createExerciseEntity();

        List<ExercisesEntity> exercisesEntityList = new ArrayList<>();
        exercisesEntityList.add(exercisesEntity);

        when(exercisesService.getAllExercises()).thenReturn(exercisesEntityList);

        ResponseEntity<Object> expected = new ResponseEntity<>(exercisesEntityList, HttpStatus.OK);

        ResponseEntity<Object> result = exercisesControllerInit.getAllExercises();
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testGetExerciseById() {

        ExerciseDto exerciseDto = UtilTestFunctions.createExerciseDto();

        when(exercisesService.getExercisesById(1)).thenReturn( new ResponseEntity<>(exerciseDto, HttpStatus.OK));

        ResponseEntity<Object> expected = new ResponseEntity<>(exerciseDto, HttpStatus.OK);

        ResponseEntity<ExerciseDto> result = exercisesControllerInit.getExerciseById(1);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testAddNewExercise() {
        when(exercisesService.addExercise(any())).thenReturn(new ResponseEntity<>(HttpStatus.OK));

        ResponseEntity<Object> expected = new ResponseEntity<>(HttpStatus.OK);

        ResponseEntity<Object> result = exercisesControllerInit.addNewExercise("exerciseName", 0, 0d, "videoPath");
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testUpdateExercise() {
        when(exercisesService.updateExercise(any())).thenReturn(new ResponseEntity<>(HttpStatus.OK));
        ResponseEntity<Object> expected = new ResponseEntity<>(HttpStatus.OK);
        ResponseEntity<Object> result = exercisesControllerInit.updateExercise(0, "exerciseName", 0, 0d, "videoPath");
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testDeleteExercise() {
        when(exercisesService.deleteExercise(anyInt())).thenReturn( new ResponseEntity<>(HttpStatus.OK));
        ResponseEntity<Object> expected = new ResponseEntity<>(HttpStatus.OK);
        ResponseEntity<Object> result = exercisesControllerInit.deleteExercise(0);
        Assertions.assertEquals(expected, result);
    }
}