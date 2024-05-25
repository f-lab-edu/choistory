package com.choistory.feed.dto;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class FeedDto {
  private String writer;
  private String profileImagePath;
  private String content;
  private List<MultipartFile> images;
  private List<FeedDto> comments;
}
