package se.nicklasrohman.backendTrainingGenerator.service.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import se.nicklasrohman.backendTrainingGenerator.entity.ExercisesEntity;
import se.nicklasrohman.backendTrainingGenerator.entity.RandomExercisesEntityCriteria;
import se.nicklasrohman.backendTrainingGenerator.repository.ExercisesRepository;
import se.nicklasrohman.backendTrainingGenerator.service.ExercisesService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;


@Service
public class ExercisesServiceInit implements ExercisesService {

    @Autowired
    ExercisesRepository exercisesRepository;

    @Override
    public List<ExercisesEntity> getAllExercises() {
        return exercisesRepository.findAll();
    }

    List<Integer> usedRandomNumbers = new ArrayList<>();

    @Override
    public ResponseEntity<ExercisesEntity> getExercisesById(int id) {

        Optional<ExercisesEntity> exercisesEntityOptional = exercisesRepository.findById(id);

        return exercisesEntityOptional.map(exercisesEntity ->
                        new ResponseEntity<>(exercisesEntity, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @Override
    public ResponseEntity<Object> createExercise(ExercisesEntity exercisesEntity) {

        try {
            exercisesRepository.save(exercisesEntity);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_IMPLEMENTED);
        }
    }

    @Override
    public ResponseEntity<Object> updateExercise(int id, ExercisesEntity exercisesEntity) {

        ExercisesEntity exercisesToUpdate = exercisesRepository.getOne(id);
        exercisesToUpdate.setExerciseName(exercisesEntity.getExerciseName());
        exercisesToUpdate.setDifficultLevel(exercisesEntity.getDifficultLevel());
        exercisesToUpdate.setEstimatedTime(exercisesEntity.getEstimatedTime());
        exercisesToUpdate.setVideoPath(exercisesEntity.getVideoPath());

        try {
            exercisesRepository.save(exercisesToUpdate);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_MODIFIED);
        }
    }

    @Override
    public ResponseEntity<Object> deleteExercise(int id) {

        try {
            exercisesRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @Override
    public ResponseEntity<List<ExercisesEntity>> getExercisesByName(String exerciseName) {

        try {
            List<ExercisesEntity> exercisesEntityList = new ArrayList<>(exercisesRepository.findByExerciseName(exerciseName));
            return new ResponseEntity<>(exercisesEntityList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public List<ExercisesEntity> getRandomExercises(RandomExercisesEntityCriteria randomExercisesEntityCriteria) {

        List<ExercisesEntity> allExercisesList = exercisesRepository.findAll();
        List<ExercisesEntity> passMaxMinDifficultyCheck = MaxMinDifficultyCheck(allExercisesList, randomExercisesEntityCriteria);
        List<ExercisesEntity> passMaxMinTimeLimitCheck = MaxMinTimeLimitCheck(passMaxMinDifficultyCheck, randomExercisesEntityCriteria);
        List<ExercisesEntity> passTagCheck = tagCheck(passMaxMinTimeLimitCheck);

        List<ExercisesEntity> result = new ArrayList<>();

        List<Integer> allExercisesIds = collectAllExerciseIds(passMaxMinTimeLimitCheck);

        for (int i = 0; i < randomExercisesEntityCriteria.getNumberOfExercises(); i++) {
            int randomNum = getRandomNum(usedRandomNumbers, allExercisesIds.size());

            int exerciseId = getExercisesId(randomNum, passMaxMinTimeLimitCheck, allExercisesIds);

            for (Iterator<ExercisesEntity> it = passMaxMinTimeLimitCheck.iterator(); it.hasNext(); ) {
                ExercisesEntity exercisesEntity = it.next();
                if (exercisesEntity.getExerciseId() == exerciseId) {
                    result.add(exercisesEntity);
                    it.remove();
                }
            }
        }

        usedRandomNumbers.clear();

        return result;
    }

    private List<ExercisesEntity> tagCheck(List<ExercisesEntity> passMaxMinTimeLimitCheck) {
        List<ExercisesEntity> result = new ArrayList<>();

        for (ExercisesEntity entity: passMaxMinTimeLimitCheck) {

        }

        return result;
    }


    private List<Integer> collectAllExerciseIds(List<ExercisesEntity> allExercises) {

        List<Integer> result = new ArrayList<>();

        for (ExercisesEntity entity : allExercises) {
            result.add(entity.getExerciseId());
        }
        return result;
    }

    private List<ExercisesEntity> MaxMinTimeLimitCheck(List<ExercisesEntity> passMaxMinDifficultyCheck, RandomExercisesEntityCriteria randomExercisesEntityCriteria) {
        List<ExercisesEntity> result = new ArrayList<>();
        for (ExercisesEntity exercises : passMaxMinDifficultyCheck) {
            if (randomExercisesEntityCriteria.getMinEstimatedTime() <= exercises.getEstimatedTime()
                    && randomExercisesEntityCriteria.getMaxEstimatedTim() >= exercises.getEstimatedTime()) {
                result.add(exercises);
            }
        }
        return result;
    }

    private List<ExercisesEntity> MaxMinDifficultyCheck(List<ExercisesEntity> allExercisesList, RandomExercisesEntityCriteria randomExercisesEntityCriteria) {

        List<ExercisesEntity> result = new ArrayList<>();
        for (ExercisesEntity exercises : allExercisesList) {
            if (randomExercisesEntityCriteria.getMinDifficulty() <= exercises.getDifficultLevel()
                    && randomExercisesEntityCriteria.getMaxDifficulty() >= exercises.getDifficultLevel()) {
                result.add(exercises);
            }
        }
        return result;
    }

    private int getRandomNum(List<Integer> usedRandomNumbers, int maxExerciseId) {
        int randomNum = ThreadLocalRandom.current().nextInt(1, maxExerciseId);

        for (int number : usedRandomNumbers) {
            if (number == randomNum) {
                getRandomNum(usedRandomNumbers, maxExerciseId);
            } else {
                usedRandomNumbers.add(number);
            }
        }

        return randomNum;
    }

    private int getExercisesId(int randomNum, List<ExercisesEntity> passMaxMinTimeLimitCheck, List<Integer> allExercisesIds) {
        int exerciseId = 0;

        for (ExercisesEntity entity : passMaxMinTimeLimitCheck) {
            if (entity.getExerciseId() == allExercisesIds.get(randomNum)) {
                exerciseId = allExercisesIds.get(randomNum);
                break;
            }
        }
        return exerciseId;
    }
}
