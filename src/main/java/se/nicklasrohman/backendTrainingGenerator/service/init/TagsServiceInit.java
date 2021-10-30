package se.nicklasrohman.backendTrainingGenerator.service.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import se.nicklasrohman.backendTrainingGenerator.entity.TagsEntity;
import se.nicklasrohman.backendTrainingGenerator.repository.TagsRepository;
import se.nicklasrohman.backendTrainingGenerator.service.TagsService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class TagsServiceInit implements TagsService {

    @Autowired
    TagsRepository tagsRepository;

    @Override
    public List<TagsEntity> getAllTags() {
        return tagsRepository.findAll();
    }

    @Override
    public ResponseEntity<TagsEntity> getTagById(int id) {

        Optional<TagsEntity> tagsEntityOptional = tagsRepository.findById(id);

        return tagsEntityOptional.map(tagsEntity ->
                        new ResponseEntity<>(tagsEntity, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @Override
    public ResponseEntity<Object> createTag(TagsEntity tagsEntity) {
        try {
            tagsRepository.save(tagsEntity);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_IMPLEMENTED);
        }
    }

    @Override
    public ResponseEntity<Object> updateTag(int id, TagsEntity tagsEntity) {
        TagsEntity tagsToUpdate = tagsRepository.getOne(id);
        tagsToUpdate.setTagName(tagsEntity.getTagName());

        try {
            tagsRepository.save(tagsToUpdate);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_MODIFIED);
        }
    }

    @Override
    public ResponseEntity<Object> deleteTag(int id) {
        try {
            tagsRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @Override
    public ResponseEntity<List<TagsEntity>> getTagByName(String TagName) {
        try {
            List<TagsEntity> tagsEntityList = new ArrayList<>(tagsRepository.findByTagName(TagName));
            return new ResponseEntity<>(tagsEntityList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
