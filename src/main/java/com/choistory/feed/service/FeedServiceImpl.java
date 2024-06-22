package com.choistory.feed.service;

import com.choistory.feed.dto.FeedDto;
import com.choistory.feed.entity.Feed;
import com.choistory.feed.repository.FeedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FeedServiceImpl implements FeedService{
  private final int PER_PAGE = 20;

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
  public Page<FeedDto> getFeeds(String userId, int currentPage) {
    Pageable pageable = PageRequest.of(currentPage, PER_PAGE);
    return feedRepository.findByUserIdAndDeletedAtIsNull(userId, pageable).map(f -> FeedDto.builder()
        .id(f.getFeedId())
        .writer(f.getUserId())
        .images(f.getImageList().stream().map(i -> i.getPath()+"/"+i.getFilename()).collect(Collectors.toList()))
        .content(f.getContent())
        .build());
  }
}
