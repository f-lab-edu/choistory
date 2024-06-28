package com.choistory.feed.service;

import com.choistory.feed.dto.FeedDto;
import com.choistory.feed.entity.Feed;
import com.choistory.feed.repository.FeedRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.data.domain.*;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.springframework.data.domain.Sort.Direction.DESC;

@Service
@RequiredArgsConstructor
public class FeedServiceImpl implements FeedService{
  private final int PER_PAGE = 20;
  private final String KEY_PREFIX_FEED = "Feed::";

  private final FeedRepository feedRepository;
  private final RedisTemplate<String, Feed> redisTemplate;

  @Override
  public Feed createFeed(FeedDto feedDto) {
    Feed feed = feedRepository.save(Feed.builder()
        .parent(feedDto.getParent().getId())
        .content(feedDto.getContent())
        .userId(feedDto.getWriter())
        .duration(feedDto.getDuration())
        .expireAt(feedDto.getExpireAt())
        .build());
    redisTemplate.opsForList().leftPush(KEY_PREFIX_FEED+feedDto.getWriter(), feed);
    return feed;
  }

  @Override
  @Transactional(readOnly = true)
  public Page<FeedDto> getFeeds(String userId, int currentPage) {
    Page<Feed> feed;
    Pageable pageable = PageRequest.of(currentPage, PER_PAGE, Sort.by(DESC, "createdAt"));
    List<Feed> cachedFeed = redisTemplate.opsForList().range(KEY_PREFIX_FEED+userId, (currentPage-1)* 20L, currentPage* 20L-1);

    if(CollectionUtils.isEmpty(cachedFeed)){
      feed = feedRepository.findByUserIdAndDeletedAtIsNullOrderByCreatedAtDesc(userId, pageable);
      redisTemplate.opsForList().rightPushAll(KEY_PREFIX_FEED+userId, feed.getContent());
    }else{
      feed = new PageImpl<>(cachedFeed, pageable, 100);
    }

    return feed.map(f -> FeedDto.builder()
    .id(f.getFeedId())
    .writer(f.getUserId())
//    .images(f.getImageList()==null?null:f.getImageList().stream().map(i -> i.getPath()+"/"+i.getFilename()).collect(Collectors.toList()))
    .content(f.getContent())
    .build());
  }
}
