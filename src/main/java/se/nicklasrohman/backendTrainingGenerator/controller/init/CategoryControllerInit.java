package se.nicklasrohman.backendTrainingGenerator.controller.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import se.nicklasrohman.backendTrainingGenerator.controller.CategoryController;
import se.nicklasrohman.backendTrainingGenerator.entity.CategoryEntity;
import se.nicklasrohman.backendTrainingGenerator.service.CategoryService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CategoryControllerInit implements CategoryController {

    @Autowired
    CategoryService categoryService;

    @Override
    public ResponseEntity<Object> getAllTags() {

        try{
            List<CategoryEntity> categoryEntityList = categoryService.getAllTags();
            if (categoryEntityList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(categoryEntityList, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public ResponseEntity<CategoryEntity> getTagById(@PathVariable int id) {
        return categoryService.getTagById(id);
    }

    @Override
    public ResponseEntity<List<CategoryEntity>> getTagByName(@PathVariable String tagName) {
        return categoryService.getTagByName(tagName);
    }

    @Override
    public ResponseEntity<Object> createNewTag(@Valid @RequestBody CategoryEntity categoryEntity) {
        return categoryService.createTag(categoryEntity);
    }

    @Override
    public ResponseEntity<Object> updateTag(@PathVariable int id, @RequestBody CategoryEntity categoryEntity) {
        return categoryService.updateTag(id, categoryEntity);
    }

    @Override
    public ResponseEntity<Object> deleteTag(@PathVariable int id) {
        return categoryService.deleteTag(id);
    }
}
