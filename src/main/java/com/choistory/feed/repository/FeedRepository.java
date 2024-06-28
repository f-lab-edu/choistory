package com.choistory.feed.repository;

import com.choistory.feed.entity.Feed;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedRepository extends JpaRepository<Feed, String> {
    Page<Feed> findByUserIdAndDeletedAtIsNullOrderByCreatedAtDesc(String username, Pageable pageable);
}
