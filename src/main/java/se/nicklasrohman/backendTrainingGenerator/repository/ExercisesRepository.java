package se.nicklasrohman.backendTrainingGenerator.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import se.nicklasrohman.backendTrainingGenerator.entity.Exercises;

public interface ExercisesRepository extends JpaRepository<Exercises, Integer>, ExercisesRepositoryCustom {

}
