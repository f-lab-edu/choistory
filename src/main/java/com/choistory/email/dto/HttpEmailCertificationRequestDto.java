package com.choistory.email.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HttpEmailCertificationRequestDto {
  private String email;
  private String key;
}
