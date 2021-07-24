package com.omnaad.loyalty.reward.service;

import com.omnaad.loyalty.reward.dto.UserDto;
import com.omnaad.loyalty.reward.entity.UserEntity;
import com.omnaad.loyalty.reward.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public String registerUser(UserDto userDto){
        UserEntity userEntity = UserEntity.builder().firstName(userDto.getFirstName()).lastName(userDto.getLastName())
                .dob(userDto.getDob()).mobileNumber(userDto.getMobileNumber()).build();
        userEntity = userRepository.save(userEntity);
        return userEntity.getMembershipId();
    }
}
