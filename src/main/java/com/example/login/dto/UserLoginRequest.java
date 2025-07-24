package com.example.login.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginRequest {
  // 아이디
  private String loginId;
  // 비밀번호
  private String password;
}
