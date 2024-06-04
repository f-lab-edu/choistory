package com.choistory.feed.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import java.time.ZonedDateTime;

@Entity
@DynamicInsert
@Builder
@Table(name = "TB_COMMENT")
@NoArgsConstructor
@AllArgsConstructor
public class Feed {
    @Id
    @Column(name = "id", length=36)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String feedId;
    @Column(length=36)
    private String parent;
    @Column(length=200)
    private String content;
    @Column(name="user_id", length=36)
    private String userId;
    @Column(name="created_at")
    private ZonedDateTime createdAt;
    @Column
    private int duration;
    @Column(name="expire_at")
    private ZonedDateTime expireAt;
    @Column(name="deleted_at")
    private ZonedDateTime deletedAt;
}
