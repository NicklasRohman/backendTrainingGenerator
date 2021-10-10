package se.nicklasrohman.backendTrainingGenerator.service.init;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import se.nicklasrohman.backendTrainingGenerator.entity.ExercisesEntity;
import se.nicklasrohman.backendTrainingGenerator.entity.RandomExercisesEntityCriteria;
import se.nicklasrohman.backendTrainingGenerator.mockData.MockEntity;
import se.nicklasrohman.backendTrainingGenerator.repository.ExercisesRepository;

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
        List<ExercisesEntity> exercisesEntityList = MockEntity.mockExercisesEntity(5,1,1.0);
        when(exercisesServiceInit.getAllExercises()).thenReturn(exercisesEntityList);

        List<ExercisesEntity> result = exercisesServiceInit.getAllExercises();
        Assertions.assertEquals(exercisesEntityList, result);
    }

    @Test
    void testGetExercisesById() {

        ResponseEntity<ExercisesEntity> expected = new ResponseEntity<>(HttpStatus.NO_CONTENT);

        ResponseEntity<ExercisesEntity> result = exercisesServiceInit.getExercisesById(0);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testAddExercise() {
        ResponseEntity<ExercisesEntity> expected = new ResponseEntity<>(HttpStatus.OK);

        ResponseEntity<Object> result = exercisesServiceInit.createExercise(new ExercisesEntity());
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testUpdateExercise() {
        ExercisesEntity exercisesEntity = MockEntity.createMockExercisesEntity(1,1.0);
        when(exercisesRepository.getOne(exercisesEntity.getExerciseId())).thenReturn(exercisesEntity);

        ResponseEntity<ExercisesEntity> expected = new ResponseEntity<>(HttpStatus.OK);

        ResponseEntity<Object> result = exercisesServiceInit.updateExercise(exercisesEntity.getExerciseId(), exercisesEntity);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testDeleteExercise() {
        ResponseEntity<Object> expected = new ResponseEntity<>(HttpStatus.OK);

        ResponseEntity<Object> result = exercisesServiceInit.deleteExercise(0);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void shouldReturnExerciseWithinDifficultLevel() {

        List<ExercisesEntity> exercisesEntityList = new ArrayList<>();

        ExercisesEntity exercisesEntity = MockEntity.createMockExercisesEntity(1, 1.0);
        exercisesEntityList.add(exercisesEntity);

        ExercisesEntity exercisesEntity2 = MockEntity.createMockExercisesEntity(5, 1.0);
        exercisesEntityList.add(exercisesEntity2);

        ExercisesEntity exercisesEntity3 = MockEntity.createMockExercisesEntity(10, 1.0);
        exercisesEntityList.add(exercisesEntity3);

        when(exercisesRepository.findAll()).thenReturn(exercisesEntityList);

        RandomExercisesEntityCriteria randomExercisesEntityCriteria = new RandomExercisesEntityCriteria();
        randomExercisesEntityCriteria.setNumberOfExercises(3);
        randomExercisesEntityCriteria.setMaxDifficulty(7);
        randomExercisesEntityCriteria.setMinDifficulty(3);
        randomExercisesEntityCriteria.setMaxEstimatedTim(10);
        randomExercisesEntityCriteria.setMinEstimatedTime(1);

        List<ExercisesEntity> expected = new ArrayList<>();
        expected.add(exercisesEntity2);

        var result = exercisesServiceInit.getRandomExercises(randomExercisesEntityCriteria);
        Assertions.assertEquals(expected.size(), result.size());
    }
}
