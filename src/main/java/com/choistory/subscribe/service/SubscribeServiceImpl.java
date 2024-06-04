package com.choistory.subscribe.service;

import com.choistory.subscribe.controller.SubscribeController;
import com.choistory.subscribe.repository.SubscribeRepository;
import com.choistory.users.entity.Follow;
import com.choistory.users.entity.FollowId;
import com.choistory.users.entity.User;
import com.choistory.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscribeServiceImpl implements SubscribeService{
  private final SubscribeRepository subscribeRepository;
  private final UserRepository userRepository;

  @Override
  public void follow(String followeeId, String followerId) {
    User followee = userRepository.findById(followeeId).orElse(null);
    User follower = userRepository.findById(followerId).orElse(null);
    if(followee == null || follower == null) {
      // todo. 적절한 exception 생성하여 대체하기
      throw new RuntimeException();
    }

    subscribeRepository.save(Follow.builder()
                    .followId(new FollowId(followee, follower))
            .build());
  }

  @Override
  public void unfollow(String followeeId, String followerId) {
    User followee = userRepository.findById(followeeId).orElse(null);
    User follower = userRepository.findById(followerId).orElse(null);

    if(followee == null || follower == null) {
      // todo. 적절한 exception 생성하여 대체하기
      throw new RuntimeException();
    }

    subscribeRepository.deleteById(new FollowId(followee, follower));

  }
}
