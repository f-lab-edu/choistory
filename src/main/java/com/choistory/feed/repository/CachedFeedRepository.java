package com.choistory.feed.repository;

import com.choistory.feed.entity.Feed;
import org.springframework.data.repository.CrudRepository;

public interface CachedFeedRepository extends CrudRepository<Feed, String> {
}
