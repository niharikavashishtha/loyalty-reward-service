package com.omnaad.loyalty.reward.repository;

import com.omnaad.loyalty.reward.entity.RewardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RewardRepository extends JpaRepository<RewardEntity,Long> {
    public Optional<RewardEntity> findByUserEntity_membershipId(String membershipId);
}
