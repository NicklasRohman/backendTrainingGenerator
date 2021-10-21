package se.nicklasrohman.backendTrainingGenerator.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="tags")
public class Tags {

    @Id
    @Column(name = "tag_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int tagId;

    @Column(name = "tag_name")
    String tagName;
}
