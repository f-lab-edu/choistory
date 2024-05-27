package com.choistory.subscribe.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SubscribeController {
  /**
   * 구독하기
   * @param followeeId
   */
  @Operation(summary = "구독하기", description="특정 유저와 구독 관계를 맺는다.")
  @Parameters({
          @Parameter(name="followeeId", description = "구독 대상자의 아이디")
  })
  @PostMapping("/v1/followee/{followeeId}")
  public ResponseEntity<Void> follow(@PathVariable String followeeId){
    return ResponseEntity.status(200).build();
  }

  @Operation(summary = "구독해제", description="특정 유저와 맺었던 구독관계를 해제한다..")
  @Parameters({
          @Parameter(name="followeeId", description = "구독 대상자의 아이디")
  })
  @DeleteMapping("/v1/followee/{followeeId}")
  public ResponseEntity<Void> unfollow(@PathVariable String followeeId){
    return ResponseEntity.status(200).build();
  }

  @Operation(summary = "구독삭제", description="자신을 구독하는 대상 중 한명을 삭제한다.")
  @Parameters({
          @Parameter(name="followerId", description = "구독자의 아이디")
  })
  @DeleteMapping("/v1/follower/{followerId}")
  public ResponseEntity<Void> deleteFollower(@PathVariable String followerId){
    return ResponseEntity.status(200).build();
  }
}
