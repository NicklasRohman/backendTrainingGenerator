package se.nicklasrohman.backendTrainingGenerator.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import se.nicklasrohman.backendTrainingGenerator.entity.ExercisesEntity;

import java.util.List;

public interface ExercisesRepository extends JpaRepository<ExercisesEntity, Integer>, ExercisesRepositoryCustom {

    List<ExercisesEntity> findByExerciseName(String exerciseName);
}
