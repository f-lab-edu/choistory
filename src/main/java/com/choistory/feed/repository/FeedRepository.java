package com.choistory.feed.repository;

import com.choistory.feed.entity.Feed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedRepository extends JpaRepository<Feed, String> {
    List<Feed> findByUserIdAndDeletedAtIsNull(String username);
}
