package com.choistory.feed.dto;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
@Builder
public class HttpFeedRequestDto {
  @NotBlank
  private String writer;
  @NotBlank
  @Size(max=200)
  private String content;
  private List<MultipartFile> images;
  private String parentId;
  private boolean isExpire;
  @Max(90)
  @Positive
  private int duration;
}
