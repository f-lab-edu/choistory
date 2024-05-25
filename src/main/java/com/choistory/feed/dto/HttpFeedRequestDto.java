package com.choistory.feed.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
public class HttpFeedRequestDto {
  private String writer;
  private String profileImagePath;
  private String content;
  private List<MultipartFile> images;
  private String parentId;
}
