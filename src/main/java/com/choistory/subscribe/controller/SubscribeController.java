package com.choistory.subscribe.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class SubscribeController {
  /**
   * 구독하기
   * @param followeeId
   */
  @PostMapping("/followee/{followeeId}")
  public void follow(@PathVariable String followeeId){

  }

  /**
   * 구독해제
   * @param followeeId
   */
  @DeleteMapping("/followee/{followeeId}")
  public void unfollow(@PathVariable String followeeId){

  }

  /**
   * 구독자 삭제
   * @param followerId
   */
  @DeleteMapping("/follower/{followerId}")
  public void deleteFollower(@PathVariable String followerId){
    
  }
}
