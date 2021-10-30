package se.nicklasrohman.backendTrainingGenerator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.nicklasrohman.backendTrainingGenerator.entity.CategoryEntity;

import java.util.List;

@RequestMapping("/tag")
public interface CategoryController {

    @GetMapping("/all")
    ResponseEntity<Object> getAllTags();

    @GetMapping("/{id}")
    ResponseEntity<CategoryEntity> getTagById(@PathVariable int id);

    @GetMapping("/search/{exerciseName}")
    ResponseEntity<List<CategoryEntity>> getTagByName(@PathVariable String tagName);

    @PostMapping("/create")
    ResponseEntity<Object> createNewTag(@RequestBody CategoryEntity categoryEntity);

    @PutMapping("/update/{id}")
    ResponseEntity<Object> updateTag(
            @PathVariable int id,
            @RequestBody CategoryEntity categoryEntity);

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Object> deleteTag(@PathVariable int id);

}
