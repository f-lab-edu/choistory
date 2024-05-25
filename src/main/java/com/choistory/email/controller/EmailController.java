package com.choistory.email.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("email")
public class EmailController {
  /**
   * 이메일 중복 확인
   * @param email
   */
  @GetMapping
  public void isDuplicatedEmail(@RequestParam String email){

  }

  /**
   * 인증용 이메일 보내기
   * @param body
   */
  @PostMapping
  public void sendEmail(@RequestBody Object body){

  }

  /**
   * 이메일 인증확인
   * @param body
   */
  @PatchMapping
  public void confirmEmailAddress(@RequestBody Object body){

  }

}
