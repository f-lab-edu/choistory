package com.choistory.users.entity;

import jakarta.persistence.*;

import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Table(name="TB_USER")
public class User {
  @Id
  @Column
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;
  @Column
  private String username;
  @Column
  private String password;
  @Column
  private String email;
  @Column
  private String nickname;
  @Column(name="email_check")
  private boolean emailCheck;
  @Column(name="profile_img")
  private String profileImg;
  @Column
  private String bio;
  @Column
  private String status;
  @Column(name="created_at")
  private ZonedDateTime createdAt;
  @Column(name="deleted_at")
  private ZonedDateTime deletedAt;
}
