package com.example.login.service;

import com.example.login.domain.Role;
import com.example.login.domain.User;
import com.example.login.dto.UserCreateRequest;
import com.example.login.dto.UserLoginRequest;
import com.example.login.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service //1. 컴포넌트 등록
@RequiredArgsConstructor
@Slf4j
public class UserService {
  //2. JPA로 SQL 쓸거니까 UserRepository를 주입받아야함
  private final UserRepository userRepository;
  //4. 비밀번호 암호화하는 컴포넌트 주입받기
  private final PasswordEncoder passwordEncoder;

  //3. 회원가입 로직을 구현
  public void register(UserCreateRequest request) {
    //3.1 이름, 아이디, 비번
    //3.1 아이디 중복검사

    //isPresent는 Optional 에서 안에 값이 존재하면 true 없으면 false를 반환해주는 메서드
    if(userRepository.findByLoginId(request.getLoginId()).isPresent()) {
      throw new DuplicateKeyException("ID 중복임");
    }

    // TODO 3.2 비밀번호 암호화
    String encodedPassword = passwordEncoder.encode(request.getPassword());


    //3.3 데이터베이스에저장
    User user = User.builder()
      .loginId(request.getLoginId())
      .password(encodedPassword)
      .name(request.getName())
      .role(Role.USER)
      .build();

    log.info("loginID : {} password : {} name : {}, role : {}", user.getLoginId(), user.getPassword(), user.getName(), user.getRole());

    //진짜 저장
    userRepository.save(user);
  }

  public void login(UserLoginRequest userLoginRequest) {
    // 1. 아이디로 사용자를 찾아야됨
    userRepository.findByLoginId(userLoginRequest.getLoginId())
      .orElseThrow(
        () -> new IllegalArgumentException("회원가입된 로그인 아이디 없음")
      );
    //2. 비번 검증 해야됨
  }
}
