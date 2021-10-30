package se.nicklasrohman.backendTrainingGenerator.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import se.nicklasrohman.backendTrainingGenerator.entity.TagsEntity;

import java.util.List;

public interface TagsRepository extends JpaRepository<TagsEntity, Integer> , TagsRepositoryCustom {

    List<TagsEntity> findByTagName(String tagName);
}
