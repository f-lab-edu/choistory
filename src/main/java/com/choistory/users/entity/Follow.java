package com.choistory.users.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="TB_FOLLOW")
public class Follow {
  @EmbeddedId
  private FollowId followId;
}
