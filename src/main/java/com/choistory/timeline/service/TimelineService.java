package com.choistory.timeline.service;

import com.choistory.timeline.controller.TimelineController;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TimelineService {
  private final TimelineController timelineController;
}
