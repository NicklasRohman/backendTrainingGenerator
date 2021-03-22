package se.nicklasrohman.backendTrainingGenerator.service.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import se.nicklasrohman.backendTrainingGenerator.dto.ExerciseDto;
import se.nicklasrohman.backendTrainingGenerator.repository.ExercisesRepository;
import se.nicklasrohman.backendTrainingGenerator.service.ExercisesService;
import se.nicklasrohman.backendTrainingGenerator.service.entity.ExercisesEntity;

import java.util.List;
import java.util.Optional;


@Service
public class ExercisesServiceInit implements ExercisesService {

    @Autowired
    ExercisesRepository exercisesRepository;

    @Override
    public List<ExercisesEntity> getAllExercises() {
        return exercisesRepository.findAll();
    }

    @Override
    public ResponseEntity<ExerciseDto> getExercisesById(int id) {

        Optional<ExercisesEntity> exercisesEntityOptional = exercisesRepository.findById(id);

        if (exercisesEntityOptional.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        ExerciseDto exerciseDto = new ExerciseDto();
        exerciseDto.setId(exercisesEntityOptional.get().getExerciseId());
        exerciseDto.setExerciseName(exercisesEntityOptional.get().getExerciseName());
        exerciseDto.setDifficultLevel(exercisesEntityOptional.get().getDifficultLevel());
        exerciseDto.setEstimatedTime(exercisesEntityOptional.get().getEstimatedTime());
        exerciseDto.setVideoPath(exercisesEntityOptional.get().getVideoPath());

        return new ResponseEntity<>(exerciseDto, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<Object> addExercise(ExerciseDto exerciseDto) {

        ExercisesEntity exercisesEntity = new ExercisesEntity();
        exercisesEntity.setExerciseName(exerciseDto.getExerciseName());
        exercisesEntity.setDifficultLevel(exerciseDto.getDifficultLevel());
        exercisesEntity.setEstimatedTime(exerciseDto.getEstimatedTime());
        exercisesEntity.setVideoPath(exerciseDto.getVideoPath());

        try {
        exercisesRepository.save(exercisesEntity);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e,HttpStatus.NOT_IMPLEMENTED);
        }
    }

    @Override
    public ResponseEntity<Object> updateExercise(ExerciseDto exerciseDto) {
        ExercisesEntity exercisesToUpdate = exercisesRepository.getOne(exerciseDto.getId());
        exercisesToUpdate.setExerciseName(exerciseDto.getExerciseName());
        exercisesToUpdate.setDifficultLevel(exerciseDto.getDifficultLevel());
        exercisesToUpdate.setEstimatedTime(exerciseDto.getEstimatedTime());
        exercisesToUpdate.setVideoPath(exerciseDto.getVideoPath());

        try {
            exercisesRepository.save(exercisesToUpdate);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e,HttpStatus.NOT_MODIFIED);
        }
    }

    @Override
    public ResponseEntity<Object> deleteExercise(int id) {

        try {
            exercisesRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e,HttpStatus.NOT_ACCEPTABLE);
        }
    }

}
