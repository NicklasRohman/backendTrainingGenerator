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
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
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
        List<ExercisesEntity> result = new ArrayList<>();

        int maxExerciseId = getMaxExercisesId(allExercisesList);

        for (int i = 0; i < randomExercisesEntityCriteria.getNumberOfExercises(); i++) {
            int randomNum = getRandomNum(usedRandomNumbers, maxExerciseId);

            for (Iterator<ExercisesEntity> it = allExercisesList.iterator(); it.hasNext(); ) {
                ExercisesEntity exercisesEntity = it.next();
                if (exercisesEntity.getExerciseId() == randomNum) {
                    result.add(exercisesEntity);
                    it.remove();
                }
            }

        }

        usedRandomNumbers.clear();

        return result;
    }

    private int getRandomNum(List<Integer> usedRandomNumbers, int maxExerciseId) {
        int randomNum = ThreadLocalRandom.current().nextInt(1, maxExerciseId + 1);

        for (int number : usedRandomNumbers) {
            if (number == randomNum) {
                getRandomNum(usedRandomNumbers, maxExerciseId);
            } else {
                usedRandomNumbers.add(number);
            }
        }

        return randomNum;
    }

    private int getMaxExercisesId(List<ExercisesEntity> allExercisesList) {
        ExercisesEntity exercisesEntity = new ExercisesEntity();

        for (ExercisesEntity ex : allExercisesList) {

            if (exercisesEntity.getExerciseId() < ex.getExerciseId()) {
                exercisesEntity.setExerciseId(ex.getExerciseId());
            }
        }

        return exercisesEntity.getExerciseId();
    }

}
