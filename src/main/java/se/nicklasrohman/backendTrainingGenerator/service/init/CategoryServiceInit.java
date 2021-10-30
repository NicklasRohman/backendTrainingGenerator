package se.nicklasrohman.backendTrainingGenerator.service.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import se.nicklasrohman.backendTrainingGenerator.entity.CategoryEntity;
import se.nicklasrohman.backendTrainingGenerator.repository.CategoryRepository;
import se.nicklasrohman.backendTrainingGenerator.service.CategoryService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CategoryServiceInit implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<CategoryEntity> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public ResponseEntity<CategoryEntity> getCategoryById(int id) {

        Optional<CategoryEntity> categoryEntityOptional = categoryRepository.findById(id);

        return categoryEntityOptional.map(CategoryEntity ->
                        new ResponseEntity<>(CategoryEntity, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @Override
    public ResponseEntity<Object> createCategory(CategoryEntity categoryEntity) {
        try {
            categoryRepository.save(categoryEntity);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_IMPLEMENTED);
        }
    }

    @Override
    public ResponseEntity<Object> updateCategory(int id, CategoryEntity categoryEntity) {
        CategoryEntity categoryToUpdate = categoryRepository.getOne(id);
        categoryToUpdate.setCategoryName(categoryEntity.getCategoryName());

        try {
            categoryRepository.save(categoryToUpdate);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_MODIFIED);
        }
    }

    @Override
    public ResponseEntity<Object> deleteCategory(int id) {
        try {
            categoryRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @Override
    public ResponseEntity<List<CategoryEntity>> getCategoryByName(String categoryName) {
        try {
            List<CategoryEntity> categoryEntityList = new ArrayList<>(categoryRepository.findByCategoryName(categoryName));
            return new ResponseEntity<>(categoryEntityList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
