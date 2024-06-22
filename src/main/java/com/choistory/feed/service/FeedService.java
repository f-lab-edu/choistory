package com.choistory.feed.service;

import com.choistory.feed.dto.FeedDto;
import com.choistory.feed.entity.Feed;
import org.springframework.data.domain.Page;

public interface FeedService {
    Feed createFeed(FeedDto feed);
    Page<FeedDto> getFeeds(String username, int currentPage);
}
