package com.choistory.feed.service;

import com.choistory.feed.controller.FeedController;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FeedServiceImpl implements FeedService{
  private final FeedController feedController;
}
