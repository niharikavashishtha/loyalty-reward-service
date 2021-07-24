package com.omnaad.loyalty.reward.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RewardDto {
    private long rewardId;
    private long rewardPoints;
    private String membershipId;
}
