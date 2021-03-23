package se.nicklasrohman.backendTrainingGenerator.service.init;

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
import se.nicklasrohman.backendTrainingGenerator.repository.ExercisesRepository;
import se.nicklasrohman.backendTrainingGenerator.service.entity.ExercisesEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

class ExercisesServiceInitTest {
    @Mock
    ExercisesRepository exercisesRepository;
    @InjectMocks
    ExercisesServiceInit exercisesServiceInit;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllExercises() {
        List<ExercisesEntity> emptyList = new ArrayList<>();
        when(exercisesServiceInit.getAllExercises()).thenReturn(emptyList);

        List<ExercisesEntity> result = exercisesServiceInit.getAllExercises();
        Assertions.assertEquals(emptyList, result);
    }

    @Test
    void testGetExercisesById() {

        ResponseEntity<ExerciseDto> expected = new ResponseEntity<>(HttpStatus.NO_CONTENT);

        ResponseEntity<ExerciseDto> result = exercisesServiceInit.getExercisesById(0);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testAddExercise() {
        ResponseEntity<ExerciseDto> expected = new ResponseEntity<>(HttpStatus.OK);
        ResponseEntity<Object> result = exercisesServiceInit.addExercise(new ExerciseDto());
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testUpdateExercise() {
        ExerciseDto exerciseDto = UtilTestFunctions.createExerciseDto();
        when(exercisesRepository.getOne(exerciseDto.getId())).thenReturn(UtilTestFunctions.createExerciseEntity());
        ResponseEntity<ExerciseDto> expected = new ResponseEntity<>(HttpStatus.OK);
        ResponseEntity<Object> result = exercisesServiceInit.updateExercise(exerciseDto);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testDeleteExercise() {
        ResponseEntity<Object> expected = new ResponseEntity<>(HttpStatus.OK);
        ResponseEntity<Object> result = exercisesServiceInit.deleteExercise(0);
        Assertions.assertEquals(expected, result);
    }

}
