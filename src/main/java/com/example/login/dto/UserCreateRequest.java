package com.example.login.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateRequest {
  // 아이디
  private String loginId;
  // 비번
  private String password;
  // 닉네임
  private String name;
}
