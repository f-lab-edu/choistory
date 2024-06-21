package com.choistory.subscribe.repository;

import com.choistory.users.entity.Follow;
import com.choistory.users.entity.FollowId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscribeRepository extends JpaRepository<Follow, FollowId> {
}
