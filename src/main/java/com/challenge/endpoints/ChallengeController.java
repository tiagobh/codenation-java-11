package com.challenge.endpoints;

import com.challenge.entity.Challenge;
import com.challenge.service.interfaces.ChallengeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/challenge")
public class ChallengeController {

    private ChallengeServiceInterface service;

    @Autowired
    public ChallengeController(ChallengeServiceInterface service) {
        this.service = service;
    }

    @GetMapping
    public List<Challenge> findByAccelerationIdAndUserId(
            @RequestParam(value = "accelerationId") Long accelerationId,
            @RequestParam(value = "userId") Long userId){
        return service.findByAccelerationIdAndUserId(accelerationId, userId);
    }
}
