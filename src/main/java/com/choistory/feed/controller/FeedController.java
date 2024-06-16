package com.choistory.feed.controller;

import com.choistory.feed.dto.FeedDto;
import com.choistory.feed.dto.HttpFeedRequestDto;
import com.choistory.feed.dto.HttpFeedResponseDto;
import com.choistory.feed.service.FeedService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;

@RestController
@RequestMapping("v1/feeds")
@RequiredArgsConstructor
public class FeedController {
  private final FeedService feedService;

  @Operation(summary = "글 쓰기", description = "자신의 피드에 글을 작성 한다. 첨부파일이 있는 경우 파일을 업로드한다.")
  @Parameters({
          @Parameter(name="body", description = "작성할 글 본문과 첨부 파일이 있는 객체", required = true)
  })
  @PostMapping
  public ResponseEntity<Void> createFeed(@RequestBody @Valid HttpFeedRequestDto body){
    if(body.getImages() != null && body.getImages().size() > 0){
      // todo. 첨부이미지 업로드 및 save
      // imageRepository.save(null);
    }

    feedService.createFeed(FeedDto.builder()
            .writer(body.getWriter())
            .content(body.getContent())
            .images(null)
            .duration(body.getDuration())
            .expireAt(body.getIsExpire() ? ZonedDateTime.now().plusDays(body.getDuration()):null)
            .parent(FeedDto.builder().id(body.getParentId()).build())
        .build());
      return ResponseEntity.status(200).build();
  }
  
  @Operation(summary = "작성 글 목록 조회", description = "특정 유저의 글 목록과 각 글에 달린 댓글을 조회한다.")
  @Parameters({
          @Parameter(name="username", description = "글 목록을 작성한 유저네임. 이 파라미터가 없으면 조회한 사람의 글 목록이나 404 오류를 반환한다.")
  })
  @GetMapping
  public ResponseEntity<HttpFeedResponseDto> GetFeeds(@RequestParam("userId") String userId){
    // todo. pagenation 추가.
    return ResponseEntity.status(200).body(HttpFeedResponseDto.builder().feed(feedService.getFeeds(userId)).build());
  }

  @Operation(summary = "특정한 1건의 글을 조회", description = "글 아이디로 특정한 글의 상세 정보를 조회한다.")
  @Parameters({
          @Parameter(name="feedId", description = "글 아이디", required = true)
  })
  @GetMapping("/{feedId}")
  public ResponseEntity<FeedDto> getFeed(@PathVariable String feedId){
    return ResponseEntity.status(200).body(null);
  }
  
  @Operation(summary = "글 삭제여부 수정", description = "해당 피드에 만료일을 설정 할 지 하지 않을지 변경할 수 있다.")
  @Parameters({
          @Parameter(name="feedId", description = "글 아이디", required = true)
  })
  @PatchMapping("/{feedId}")
  public ResponseEntity<Void> updateFeed(@PathVariable String feedId){
    return ResponseEntity.status(200).build();
  }

  @Operation(summary = "글 삭제")
  @Parameters({
          @Parameter(name="feedId", description = "글 아이디", required = true)
  })
  @DeleteMapping("/{feedId}")
  public ResponseEntity<Void> deleteFeed(@PathVariable String feedId){
    return ResponseEntity.status(200).build();
  }

}
