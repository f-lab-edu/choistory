package com.choistory.feed.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("feed")
public class FeedController {
  /**
   * 글 쓰기
   * @param body
   */
  @PostMapping
  public void createFeed(@RequestBody Object body){

  }

  /**
   * 특정 유저의 글 목록과 각 글에 달린 댓글 수 조회
   */
  @GetMapping
  public void GetFeeds(@RequestParam("username") String username){
  }

  /**
   * 특정 글 상세와 글에 딸린 댓글을 함께 조회
   * @param feedId
   */
  @GetMapping("/{feedId}")
  public void getFeed(@PathVariable String feedId){

  }

  /**
   * 글의 삭제여부 업데이트
   * @param feedId
   */
  @PatchMapping("/{feedId}")
  public void updateFeed(@PathVariable String feedId){

  }

  /**
   * 글 삭제
   * @param feedId
   */
  @DeleteMapping("/{feedId}")
  public void deleteFeed(@PathVariable String feedId){

  }

}
