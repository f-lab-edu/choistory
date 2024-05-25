package com.choistory.users.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HttpUserProfileResponseDto {
  private String username;
  private String bio;
  private String profileImagePath;
  private String headerImagePath;
}
