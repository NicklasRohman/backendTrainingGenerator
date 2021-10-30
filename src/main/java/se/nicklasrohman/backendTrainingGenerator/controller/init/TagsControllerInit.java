package se.nicklasrohman.backendTrainingGenerator.controller.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import se.nicklasrohman.backendTrainingGenerator.controller.TagsController;
import se.nicklasrohman.backendTrainingGenerator.entity.TagsEntity;
import se.nicklasrohman.backendTrainingGenerator.service.TagsService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TagsControllerInit implements TagsController {

    @Autowired
    TagsService tagsService;

    @Override
    public ResponseEntity<Object> getAllTags() {

        try{
            List<TagsEntity> tagsEntityList = tagsService.getAllTags();
            if (tagsEntityList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tagsEntityList, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public ResponseEntity<TagsEntity> getTagById(@PathVariable int id) {
        return tagsService.getTagById(id);
    }

    @Override
    public ResponseEntity<List<TagsEntity>> getTagByName(@PathVariable String tagName) {
        return tagsService.getTagByName(tagName);
    }

    @Override
    public ResponseEntity<Object> createNewTag(@Valid @RequestBody TagsEntity tagsEntity) {
        return tagsService.createTag(tagsEntity);
    }

    @Override
    public ResponseEntity<Object> updateTag(@PathVariable int id, @RequestBody TagsEntity tagsEntity) {
        return tagsService.updateTag(id, tagsEntity);
    }

    @Override
    public ResponseEntity<Object> deleteTag(@PathVariable int id) {
        return tagsService.deleteTag(id);
    }
}
