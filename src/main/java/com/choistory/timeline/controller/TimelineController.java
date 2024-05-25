package com.choistory.timeline.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("timeline")
public class TimelineController {
  /**
   * 타임라인 새로 가져오기
   * @param offset
   */
  @GetMapping
  public void getTimeline(@RequestParam(required = false) int offset){

  }
}
