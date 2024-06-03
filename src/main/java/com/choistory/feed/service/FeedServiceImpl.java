package com.choistory.feed.service;

import com.choistory.feed.dto.FeedDto;
import com.choistory.feed.entity.Feed;
import com.choistory.feed.repository.FeedRepository;
import com.choistory.file.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FeedServiceImpl implements FeedService{
  private final FeedRepository feedRepository;

  @Override
  @Transactional
  public Feed createFeed(FeedDto feed) {
    if(feed.getImages().size() > 0){
      // todo. 첨부이미지 업로드 및 save
      // imageRepository.save(null);
    }
    return feedRepository.save(Feed.builder()
        .parent(feed.getParent().getId())
        .content(feed.getContent())
        .userId(feed.getWriter())
        .duration(feed.getDuration())
        .expireAt(feed.getExpireAt())
        .build());
  }
}
