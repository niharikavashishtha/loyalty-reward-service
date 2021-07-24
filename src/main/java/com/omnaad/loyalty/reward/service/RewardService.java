package com.omnaad.loyalty.reward.service;

import com.omnaad.loyalty.reward.dto.RewardDto;
import com.omnaad.loyalty.reward.entity.RewardEntity;
import com.omnaad.loyalty.reward.entity.UserEntity;
import com.omnaad.loyalty.reward.repository.RewardRepository;
import com.omnaad.loyalty.reward.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RewardService {
    private final RewardRepository rewardRepository;
    private final UserRepository userRepository;
    public RewardDto getRewards(String membershipId){
        RewardEntity rewardEntity = rewardRepository.findByUserEntity_membershipId(membershipId)
                .orElseThrow(() -> new EntityNotFoundException("There is no user... "));
        RewardDto rewardDto = new RewardDto();
        rewardDto.setRewardId(rewardEntity.getRewardId());
        rewardDto.setRewardPoints(rewardEntity.getRewardPoints());
        rewardDto.setMembershipId(rewardEntity.getUserEntity().getMembershipId());
        return rewardDto;
    }
    public long postRewards(RewardDto rewardDto){
        UserEntity userEntity = userRepository.findById(rewardDto.getMembershipId())
                .orElseThrow(() -> new EntityNotFoundException("user not fund...."));
       RewardEntity rewardEntity = rewardRepository.findByUserEntity_membershipId(userEntity.getMembershipId())
               .map(id ->
                       {
                           id.setRewardPoints(id.getRewardPoints()+rewardDto.getRewardPoints());
                           return id;
                       }
               )
               .orElseGet(() -> RewardEntity.builder().userEntity(userEntity).rewardId(rewardDto.getRewardId())
                       .rewardPoints(rewardDto.getRewardPoints()).build());
        rewardEntity = rewardRepository.save(rewardEntity);
        return rewardEntity.getRewardId();

    }
}
