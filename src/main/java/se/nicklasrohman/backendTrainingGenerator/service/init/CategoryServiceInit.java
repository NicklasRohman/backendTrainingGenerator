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
    public List<CategoryEntity> getAllTags() {
        return categoryRepository.findAll();
    }

    @Override
    public ResponseEntity<CategoryEntity> getTagById(int id) {

        Optional<CategoryEntity> tagsEntityOptional = categoryRepository.findById(id);

        return tagsEntityOptional.map(tagsEntity ->
                        new ResponseEntity<>(tagsEntity, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @Override
    public ResponseEntity<Object> createTag(CategoryEntity categoryEntity) {
        try {
            categoryRepository.save(categoryEntity);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_IMPLEMENTED);
        }
    }

    @Override
    public ResponseEntity<Object> updateTag(int id, CategoryEntity categoryEntity) {
        CategoryEntity tagsToUpdate = categoryRepository.getOne(id);
        tagsToUpdate.setTagName(categoryEntity.getTagName());

        try {
            categoryRepository.save(tagsToUpdate);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_MODIFIED);
        }
    }

    @Override
    public ResponseEntity<Object> deleteTag(int id) {
        try {
            categoryRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @Override
    public ResponseEntity<List<CategoryEntity>> getTagByName(String TagName) {
        try {
            List<CategoryEntity> categoryEntityList = new ArrayList<>(categoryRepository.findByTagName(TagName));
            return new ResponseEntity<>(categoryEntityList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
