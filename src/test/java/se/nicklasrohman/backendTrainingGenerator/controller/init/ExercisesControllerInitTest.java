package se.nicklasrohman.backendTrainingGenerator.controller.init;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import se.nicklasrohman.backendTrainingGenerator.entity.ExercisesEntity;
import se.nicklasrohman.backendTrainingGenerator.mockData.MockEntity;
import se.nicklasrohman.backendTrainingGenerator.service.ExercisesService;

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

        ExercisesEntity exercisesEntity = MockEntity.createMockExercisesEntity(1,1.0);

        List<ExercisesEntity> exercisesEntityList = new ArrayList<>();
        exercisesEntityList.add(exercisesEntity);

        when(exercisesService.getAllExercises()).thenReturn(exercisesEntityList);

        ResponseEntity<Object> expected = new ResponseEntity<>(exercisesEntityList, HttpStatus.OK);

        ResponseEntity<Object> result = exercisesControllerInit.getAllExercises();
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testGetExerciseById() {

        ExercisesEntity exercisesEntity = MockEntity.createMockExercisesEntity(1,1.0);

        when(exercisesService.getExercisesById(1)).thenReturn( new ResponseEntity<>(exercisesEntity, HttpStatus.OK));

        ResponseEntity<Object> expected = new ResponseEntity<>(exercisesEntity, HttpStatus.OK);

        ResponseEntity<ExercisesEntity> result = exercisesControllerInit.getExerciseById(1);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testAddNewExercise() {
        when(exercisesService.createExercise(any())).thenReturn(new ResponseEntity<>(HttpStatus.OK));

        ResponseEntity<Object> expected = new ResponseEntity<>(HttpStatus.OK);

        ExercisesEntity exercisesEntity = MockEntity.createMockExercisesEntity(1,1.0);

        ResponseEntity<Object> result = exercisesControllerInit.createNewExercise(exercisesEntity);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testUpdateExercise() {
        when(exercisesService.updateExercise(anyInt(), any())).thenReturn(new ResponseEntity<>(HttpStatus.OK));
        ResponseEntity<Object> expected = new ResponseEntity<>(HttpStatus.OK);
        ResponseEntity<Object> result = exercisesControllerInit.updateExercise(0, new ExercisesEntity());
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