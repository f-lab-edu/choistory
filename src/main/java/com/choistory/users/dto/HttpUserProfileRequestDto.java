package com.choistory.users.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class HttpUserProfileRequestDto {
  private String username;
  private String bio;
}
