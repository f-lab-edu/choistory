package com.choistory.feed.repository;

import com.choistory.feed.entity.Feed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedRepository extends JpaRepository<Feed, String> {
}
