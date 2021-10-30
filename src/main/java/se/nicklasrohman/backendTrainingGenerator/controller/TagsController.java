package se.nicklasrohman.backendTrainingGenerator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.nicklasrohman.backendTrainingGenerator.entity.TagsEntity;

import java.util.List;

@RequestMapping("/tag")
public interface TagsController{

    @GetMapping("/all")
    ResponseEntity<Object> getAllTags();

    @GetMapping("/{id}")
    ResponseEntity<TagsEntity> getTagById(@PathVariable int id);

    @GetMapping("/search/{exerciseName}")
    ResponseEntity<List<TagsEntity>> getTagByName(@PathVariable String tagName);

    @PostMapping("/create")
    ResponseEntity<Object> createNewTag(@RequestBody TagsEntity tagsEntity);

    @PutMapping("/update/{id}")
    ResponseEntity<Object> updateTag(
            @PathVariable int id,
            @RequestBody TagsEntity tagsEntity);

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Object> deleteTag(@PathVariable int id);

}
