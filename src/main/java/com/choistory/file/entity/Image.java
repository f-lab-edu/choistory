package com.choistory.file.entity;

import com.choistory.feed.entity.Feed;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name="TB_IMAGE")
public class Image {
    @Id
    @Column(name = "id", length=36)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String  imageId;
    @JoinColumn(name = "comment_id")
    @ManyToOne
    private Feed comment;
    @Column
    private String path;
    @Column
    private String filename;
    @Column
    private String alt;
}
