package se.nicklasrohman.backendTrainingGenerator.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import se.nicklasrohman.backendTrainingGenerator.entity.CategoryEntity;

import java.util.List;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> , CategoryRepositoryCustom {

    List<CategoryEntity> findByTagName(String tagName);
}
