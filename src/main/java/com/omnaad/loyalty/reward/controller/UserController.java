package com.omnaad.loyalty.reward.controller;

import com.omnaad.loyalty.reward.dto.UserDto;
import com.omnaad.loyalty.reward.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;
    @ResponseBody
    @PostMapping("/users")
    public ResponseEntity<String> registerUser(@RequestBody UserDto userDto){
        String membershipId = userService.registerUser(userDto);
        return ResponseEntity.status(HttpStatus.OK).body(membershipId);
    }
}
