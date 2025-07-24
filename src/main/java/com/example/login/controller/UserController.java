package com.example.login.controller;

import com.example.login.dto.UserCreateRequest;
import com.example.login.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  // 얘는 html 파일 가져다 주는 애
  @GetMapping("/register")
  public String showRegister(Model model) {
    return "register";
  }

  //버튼을 누르면 post 요청 보내는 애
  @PostMapping("/register")
  public String register(UserCreateRequest request) {
    userService.register(request);
    return "redirect:/";
  }

  //로그인 html파일 가져다 주는 애
  @GetMapping("/login")
  public String showLogin(Model model) {
    return "login";
  }
}
