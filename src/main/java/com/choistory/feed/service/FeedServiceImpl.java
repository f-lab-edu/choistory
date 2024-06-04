package com.choistory.feed.service;

import com.choistory.feed.dto.FeedDto;
import com.choistory.feed.entity.Feed;
import com.choistory.feed.repository.FeedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FeedServiceImpl implements FeedService{
  private final FeedRepository feedRepository;

  @Override
  @Transactional
  public Feed createFeed(FeedDto feed) {

    return feedRepository.save(Feed.builder()
        .parent(feed.getParent().getId())
        .content(feed.getContent())
        .userId(feed.getWriter())
        .duration(feed.getDuration())
        .expireAt(feed.getExpireAt())
        .build());
  }

  @Override
  public List<FeedDto> getFeeds(String userId) {
    List<Feed> feeds = feedRepository.findByUserIdAndDeletedAtIsNull(userId);
    return feeds.stream().map(f -> FeedDto.builder()
        .id(f.getFeedId())
        .writer(f.getUserId())
        .images(f.getImageList().stream().map(i -> i.getPath()+"/"+i.getFilename()).collect(Collectors.toList()))
        .content(f.getContent())
        .build()).collect(Collectors.toList());
  }
}
