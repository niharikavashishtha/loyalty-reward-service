package com.omnaad.loyalty.reward.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
@Table(name = "REWARD")
public class RewardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long rewardId;
    private long rewardPoints;
    @OneToOne
    @JoinColumn(name = "membershipId")
    private UserEntity userEntity;
}
