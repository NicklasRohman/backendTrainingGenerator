package se.nicklasrohman.backendTrainingGenerator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.nicklasrohman.backendTrainingGenerator.entity.CategoryEntity;

import java.util.List;

@RequestMapping("/category")
public interface CategoryController {

    @GetMapping("/all")
    ResponseEntity<Object> getAllCategory();

    @GetMapping("/{id}")
    ResponseEntity<CategoryEntity> getCategoryById(@PathVariable int id);

    @GetMapping("/search/{exerciseName}")
    ResponseEntity<List<CategoryEntity>> getCategoryByName(@PathVariable String categoryName);

    @PostMapping("/create")
    ResponseEntity<Object> createNewCategory(@RequestBody CategoryEntity categoryEntity);

    @PutMapping("/update/{id}")
    ResponseEntity<Object> updateCategory(
            @PathVariable int id,
            @RequestBody CategoryEntity categoryEntity);

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Object> deleteCategory(@PathVariable int id);

}
