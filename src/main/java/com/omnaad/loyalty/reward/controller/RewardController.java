package com.omnaad.loyalty.reward.controller;


import com.omnaad.loyalty.reward.dto.RewardDto;
import com.omnaad.loyalty.reward.service.RewardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class RewardController {
    private final RewardService rewardService;
    @GetMapping(path = "/rewards/{membershipId}")
    @ResponseBody
    public ResponseEntity<RewardDto> getRewardPoints(@PathVariable("membershipId") String membershipId){
       return  ResponseEntity.status(HttpStatus.OK).body(rewardService.getRewards(membershipId)) ;
    }
    @PostMapping("/rewards")
    public ResponseEntity<Long> postRewards(@RequestBody RewardDto rewardDto){
        long rewardId = rewardService.postRewards(rewardDto);
        return ResponseEntity.status(HttpStatus.OK).body(rewardId);
    }
}
