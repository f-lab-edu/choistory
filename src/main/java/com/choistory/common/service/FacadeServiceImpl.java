package com.choistory.common.service;

import com.choistory.feed.dto.FeedDto;
import com.choistory.feed.entity.Feed;
import com.choistory.feed.service.FeedService;
import com.choistory.file.service.FileService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FacadeServiceImpl implements FacadeService{
  private final FeedService feedService;
  private final FileService fileService;

  @Override
  public Feed createFeed(FeedDto feedDto, List<MultipartFile> images) {
    Feed feed = feedService.createFeed(feedDto);
    if(CollectionUtils.isNotEmpty(images)){
      // todo. 첨부이미지 업로드 및 save
      // imageRepository.save(null);
    }
    return feed;
  }
}
