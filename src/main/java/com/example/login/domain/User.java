package com.example.login.domain;

import jakarta.persistence.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User extends BaseEntity {
  // pk
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long user_id;

  // 이름
  private String name;
  // 로그인 아이디
  private String loginId;
  // 비밀번호
  private String password;

  // 역할
  @Builder.Default
  @Enumerated(EnumType.STRING)
  private Role role = Role.USER;
}
