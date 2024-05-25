package com.choistory.feed.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
public class HttpFeedResponseDto {
  private List<FeedDto> feed;
}
