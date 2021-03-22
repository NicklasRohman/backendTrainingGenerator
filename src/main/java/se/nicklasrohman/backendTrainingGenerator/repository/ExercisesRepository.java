package se.nicklasrohman.backendTrainingGenerator.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import se.nicklasrohman.backendTrainingGenerator.service.entity.ExercisesEntity;

public interface ExercisesRepository extends JpaRepository<ExercisesEntity, Integer>, ExercisesRepositoryCustom {

}
