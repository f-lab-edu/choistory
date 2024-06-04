package com.choistory.subscribe.controller;

import com.choistory.subscribe.service.SubscribeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class SubscribeController {
  private final SubscribeService subscribeService;
  // todo. 인증 도입후 로그인한 유저의 아이디값으로 대신하기
  String followeeId = "anonymous";
  String followerId = "anonymous";

  @Operation(summary = "구독하기", description="특정 유저와 구독 관계를 맺는다.")
  @Parameters({
          @Parameter(name="followeeId", description = "구독 대상자의 아이디")
  })
  @PostMapping("/v1/followee/{followeeId}")
  public ResponseEntity<Void> follow(@PathVariable String followeeId){
    subscribeService.follow(followeeId, followerId);
    return ResponseEntity.status(200).build();
  }

  @Operation(summary = "구독해제", description="특정 유저와 맺었던 구독관계를 해제한다..")
  @Parameters({
          @Parameter(name="followeeId", description = "구독 대상자의 아이디")
  })
  @DeleteMapping("/v1/followee/{followeeId}")
  public ResponseEntity<Void> unfollow(@PathVariable String followeeId){
    subscribeService.unfollow(followeeId, followerId);
    return ResponseEntity.status(200).build();
  }

  @Operation(summary = "구독삭제", description="자신을 구독하는 대상 중 한명을 삭제한다.")
  @Parameters({
          @Parameter(name="followerId", description = "구독자의 아이디")
  })
  @DeleteMapping("/v1/follower/{followerId}")
  public ResponseEntity<Void> deleteFollower(@PathVariable String followerId){
    subscribeService.unfollow(followeeId, followerId);
    return ResponseEntity.status(200).build();
  }
}
