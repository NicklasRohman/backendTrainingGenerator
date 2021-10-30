package se.nicklasrohman.backendTrainingGenerator.service;


import org.springframework.http.ResponseEntity;
import se.nicklasrohman.backendTrainingGenerator.entity.TagsEntity;

import java.util.List;

public interface TagsService {

    List<TagsEntity> getAllTags();

    ResponseEntity<TagsEntity> getTagById(int id);

    ResponseEntity<Object> createTag(TagsEntity tagsEntity);

    ResponseEntity<Object> updateTag(int id, TagsEntity tagsEntity);

    ResponseEntity<Object> deleteTag(int id);

    ResponseEntity<List<TagsEntity>> getTagByName(String TagName);
}
