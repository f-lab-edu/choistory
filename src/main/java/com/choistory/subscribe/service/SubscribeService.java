package com.choistory.subscribe.service;

public interface SubscribeService {
  void follow(String followeeId, String followerId);
  void unfollow(String followeeId, String followerId);
}
