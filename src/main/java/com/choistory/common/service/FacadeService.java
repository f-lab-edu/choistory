package com.choistory.common.service;


import com.choistory.feed.dto.FeedDto;
import com.choistory.feed.entity.Feed;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FacadeService {
  Feed createFeed(FeedDto feedDto, List<MultipartFile> images);
}
