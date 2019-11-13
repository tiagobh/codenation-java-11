package com.challenge.endpoints;

import com.challenge.entity.Acceleration;
import com.challenge.service.interfaces.AccelerationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/acceleration")
public class AccelerationController {

    private AccelerationServiceInterface service;

    @Autowired
    public AccelerationController(AccelerationServiceInterface service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Optional<Acceleration> findById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping
    public List<Acceleration> findByCompanyId(@RequestParam(value = "companyId") Long companyId){
        return service.findByCompanyId(companyId);
    }
}
