package se.nicklasrohman.backendTrainingGenerator.controller.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import se.nicklasrohman.backendTrainingGenerator.controller.CategoryController;
import se.nicklasrohman.backendTrainingGenerator.entity.CategoryEntity;
import se.nicklasrohman.backendTrainingGenerator.service.CategoryService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CategoryControllerInit implements CategoryController {

    @Autowired
    CategoryService categoryService;

    @Override
    public ResponseEntity<Object> getAllCategory() {

        try{
            List<CategoryEntity> categoryEntityList = categoryService.getAllCategory();
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
    public ResponseEntity<CategoryEntity> getCategoryById(@PathVariable int id) {
        return categoryService.getCategoryById(id);
    }

    @Override
    public ResponseEntity<List<CategoryEntity>> getCategoryByName(@PathVariable String categoryName) {
        return categoryService.getCategoryByName(categoryName);
    }

    @Override
    public ResponseEntity<Object> createNewCategory(@Valid @RequestBody CategoryEntity categoryEntity) {
        return categoryService.createCategory(categoryEntity);
    }

    @Override
    public ResponseEntity<Object> updateCategory(@PathVariable int id, @RequestBody CategoryEntity categoryEntity) {
        return categoryService.updateCategory(id, categoryEntity);
    }

    @Override
    public ResponseEntity<Object> deleteCategory(@PathVariable int id) {
        return categoryService.deleteCategory(id);
    }
}
