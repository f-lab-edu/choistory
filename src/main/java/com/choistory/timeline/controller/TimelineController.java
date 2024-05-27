package com.choistory.timeline.controller;

import com.choistory.feed.dto.FeedDto;
import com.choistory.feed.dto.HttpFeedResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/timeline")
public class TimelineController {
  @Operation(summary = "타임라인 가져오기", description = "자신의 글과 자신이 구독하는 유저들의 글을 한번에 20건씩 조회한다.")
  @Parameters({
          @Parameter(name="offset", description = "타임라인의 몇번째 글부터 가져올지 나타내는 숫자")
  })
  @GetMapping
  public ResponseEntity<HttpFeedResponseDto> getTimeline(@RequestParam(required = false) int offset){
    return ResponseEntity.status(200).body(null);
  }
}
