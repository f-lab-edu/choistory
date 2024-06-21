package com.choistory.users.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class FollowId implements Serializable {
  @JoinColumn
  @ManyToOne
  private User followee;

  @JoinColumn
  @ManyToOne
  private User follower;

}
