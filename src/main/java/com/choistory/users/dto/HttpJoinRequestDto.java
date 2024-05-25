package com.choistory.users.dto;

import lombok.Getter;

@Getter
public class HttpJoinRequestDto {
  private String username;
  private String email;
  private String password;
}
