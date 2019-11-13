package com.challenge.endpoints;

import com.challenge.dto.SubmissionDTO;
import com.challenge.mappers.SubmissionMapper;
import com.challenge.service.interfaces.SubmissionServiceInterface;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/submission")
public class SubmissionController {

    private SubmissionServiceInterface service;
    private SubmissionMapper map;

    public SubmissionController(SubmissionServiceInterface service, SubmissionMapper map) {
        this.service = service;
        this.map = map;
    }

    @GetMapping
    public List<SubmissionDTO> findByChallengeIdAndAccelerationId(@RequestParam(value = "challengeId") Long challengeId,
                                                                  @RequestParam(value = "accelerationId") Long accelerationId){
        return map.map(service.findByChallengeIdAndAccelerationId(challengeId, accelerationId));
    }
}
