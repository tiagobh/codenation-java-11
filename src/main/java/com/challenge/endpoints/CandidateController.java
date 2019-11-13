package com.challenge.endpoints;

import com.challenge.dto.CandidateDTO;
import com.challenge.entity.Candidate;
import com.challenge.mappers.CandidateMapper;
import com.challenge.service.interfaces.CandidateServiceInterface;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    private CandidateServiceInterface service;
    private CandidateMapper map;

    public CandidateController(CandidateServiceInterface service, CandidateMapper map) {
        this.service = service;
        this.map = map;
    }

    @GetMapping("/{userId}/{companyId}/{accelerationId}")
    public CandidateDTO findById(@PathVariable Long userId,
                                 @PathVariable Long companyId,
                                 @PathVariable Long accelerationId){
        return map.map(service.findById(userId, companyId, accelerationId).orElse(new Candidate()));
    }

    @GetMapping
    public List<CandidateDTO> findAll(@RequestParam(value = "companyId", required = false) Long companyId,
                                      @RequestParam(value = "accelerationId", required = false) Long accelerationId){
        return Objects.nonNull(accelerationId) ? findByAccelerationId(accelerationId) : findByCompanyId(companyId);
    }

    public List<CandidateDTO> findByCompanyId(Long companyId){
        return map.map(service.findByCompanyId(companyId));
    }

    public List<CandidateDTO> findByAccelerationId(Long accelerationId){
        return map.map(service.findByAccelerationId(accelerationId));
    }
}
