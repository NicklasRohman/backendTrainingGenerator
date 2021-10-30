package se.nicklasrohman.backendTrainingGenerator.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="category")
public class CategoryEntity {

    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int categoryId;

    @Column(name = "category_name")
    String categoryName;

    @Column(name = "category_description")
    String categoryDescription;

    @ManyToMany
    List<ExercisesEntity> exercisesEntityList;
}
