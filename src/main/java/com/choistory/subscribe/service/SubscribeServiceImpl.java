package com.choistory.subscribe.service;

import com.choistory.subscribe.controller.SubscribeController;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscribeServiceImpl implements SubscribeService{
  private final SubscribeController subscribeController;
}
