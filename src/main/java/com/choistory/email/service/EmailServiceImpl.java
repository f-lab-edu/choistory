package com.choistory.email.service;

import com.choistory.email.controller.EmailController;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService{
  private final EmailController emailController;
}
