package com.choistory.feed.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class HttpFeedResponseDto {
  private List<FeedDto> feeds;
}
