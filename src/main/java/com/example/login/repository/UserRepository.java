package com.example.login.repository;

import com.example.login.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

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
