package com.choistory.users.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
  /**
   * 회원가입
   */
  @PostMapping
  public void createUser(){

  }

  /**
   * 회원 정보(프로필) 조회
   * @param userId
   */
  @GetMapping("/{userId}")
  public void getUser(@PathVariable String userId){

  }

  /**
   * 회원 정보(프로필) 업데이트
   * @param userId
   */
  @PostMapping("/{userId}")
  public void updateProfile(@PathVariable String userId){

  }

  /**
   * 회원 프로필 이미지 업데이트
   * @param userId
   * @param imageId
   */
  @PostMapping("/{userId}/image/{imageId}")
  public void updateProfileImage(@PathVariable String userId, @PathVariable String imageId){

  }

  /**
   * 회원탈퇴
   * @param userId
   */
  @DeleteMapping("/{userId}")
  public void deleteUser(@PathVariable String userId){

  }
}
