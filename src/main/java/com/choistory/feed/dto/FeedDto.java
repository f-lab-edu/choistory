package com.choistory.feed.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.time.ZonedDateTime;
import java.util.List;

@Builder
@Getter
public class FeedDto {
  private String id;
  private String writer;
  private String profileImagePath;
  private String content;
  private List<String> images;
  private int duration;
  private ZonedDateTime expireAt;
  private FeedDto parent;
  private List<FeedDto> comments;
}
