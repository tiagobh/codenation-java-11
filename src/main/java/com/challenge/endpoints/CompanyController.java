package com.challenge.endpoints;

import com.challenge.entity.Company;
import com.challenge.service.interfaces.CompanyServiceInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private CompanyServiceInterface servvice;

    public CompanyController(CompanyServiceInterface servvice) {
        this.servvice = servvice;
    }

    @GetMapping("/{id}")
    public Optional<Company> findById(@PathVariable Long id){
        return servvice.findById(id);
    }

    @GetMapping
    public List<Company> findAll(@RequestParam(value = "accelerationId", required = false) Long accelerationId,
                                                   @RequestParam(value = "userId", required = false) Long userId){
        return Objects.nonNull(userId) ? findByUserId(userId) : findByAccelerationId(accelerationId);
    }

    public List<Company> findByAccelerationId(@RequestParam(value = "accelerationId", required = false) Long accelerationId){
        return servvice.findByAccelerationId(accelerationId);
    }

    public List<Company> findByUserId(Long userId){
        return servvice.findByUserId(userId);
    }
}
