package com.choistory.file.entity;

import jakarta.persistence.*;

@Entity
@Table(name="TB_IMAGE")
public class Image {
    @Id
    @Column(name = "id", length=36)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String  imageId;
    @Column(name = "comment_id", length=36)
    private String commentId;
    @Column
    private String path;
    @Column
    private String filename;
    @Column
    private String alt;
}
