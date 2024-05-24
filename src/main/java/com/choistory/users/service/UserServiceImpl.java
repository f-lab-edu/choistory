package com.choistory.users.service;

import com.choistory.users.controller.UserController;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl {
  private final UserController userController;
}
