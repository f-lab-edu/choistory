package com.choistory.feed.service;

import com.choistory.feed.dto.FeedDto;
import com.choistory.feed.entity.Feed;

public interface FeedService {
    Feed createFeed(FeedDto feed);
}
