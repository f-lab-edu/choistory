package com.choistory.common.service;


import com.choistory.feed.dto.FeedDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FacadeService {
  void createFeed(FeedDto feedDto, List<MultipartFile> images);
}
