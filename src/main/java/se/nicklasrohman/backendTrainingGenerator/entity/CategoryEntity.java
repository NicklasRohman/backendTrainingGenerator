package se.nicklasrohman.backendTrainingGenerator.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="tags")
public class CategoryEntity {

    @Id
    @Column(name = "tag_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int tagId;

    @Column(name = "tag_name")
    String tagName;

    @Column(name = "tag_description")
    String tagDescription;

    @ManyToMany
    List<ExercisesEntity> exercisesEntityList;
}
