package com.choistory.feed.service;

import com.choistory.feed.dto.FeedDto;
import com.choistory.feed.entity.Feed;

import java.util.List;

public interface FeedService {
    Feed createFeed(FeedDto feed);
    List<FeedDto> getFeeds(String username);
}
