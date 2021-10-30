package se.nicklasrohman.backendTrainingGenerator.service;


import org.springframework.http.ResponseEntity;
import se.nicklasrohman.backendTrainingGenerator.entity.CategoryEntity;

import java.util.List;

public interface CategoryService {

    List<CategoryEntity> getAllCategory();

    ResponseEntity<CategoryEntity> getCategoryById(int id);

    ResponseEntity<Object> createCategory(CategoryEntity categoryEntity);

    ResponseEntity<Object> updateCategory(int id, CategoryEntity categoryEntity);

    ResponseEntity<Object> deleteCategory(int id);

    ResponseEntity<List<CategoryEntity>> getCategoryByName(String categoryName);
}
