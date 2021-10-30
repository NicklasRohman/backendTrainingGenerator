package se.nicklasrohman.backendTrainingGenerator.service;


import org.springframework.http.ResponseEntity;
import se.nicklasrohman.backendTrainingGenerator.entity.CategoryEntity;

import java.util.List;

public interface CategoryService {

    List<CategoryEntity> getAllTags();

    ResponseEntity<CategoryEntity> getTagById(int id);

    ResponseEntity<Object> createTag(CategoryEntity categoryEntity);

    ResponseEntity<Object> updateTag(int id, CategoryEntity categoryEntity);

    ResponseEntity<Object> deleteTag(int id);

    ResponseEntity<List<CategoryEntity>> getTagByName(String TagName);
}
