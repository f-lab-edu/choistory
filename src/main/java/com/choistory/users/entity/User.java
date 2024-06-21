package com.choistory.users.entity;

import jakarta.persistence.*;

import java.time.ZonedDateTime;

@Entity
@Table(name="TB_USER")
public class User {
  @Id
  @Column
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;
  @Column(nullable=false, unique = true)
  private String username;
  @Column(nullable=false)
  private String password;
  @Column(nullable=false)
  private String email;
  @Column(nullable=false)
  private String nickname;
  @Column(name="email_check", nullable=false)
  private boolean isEmailChecked;
  @Column(name="profile_img",nullable=false)
  private String profileImg;
  @Column
  private String bio;
  @Column(nullable=false)
  private String status;
  @Column(name="created_at", nullable=false)
  private ZonedDateTime createdAt;
  @Column(name="deleted_at")
  private ZonedDateTime deletedAt;
}
