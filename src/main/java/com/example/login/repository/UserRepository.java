package com.example.login.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.login.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByLoginId(String loginId);

  /*
  JPA는 메서드 이름만 보고 쿼리를 만듬

  User 테이블에서
  select *
  from user
  where loginId = ?
   */
}
