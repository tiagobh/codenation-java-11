package com.challenge.endpoints;

import com.challenge.entity.User;
import com.challenge.service.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController()
@RequestMapping("/user")
public class UserController {

    private UserServiceInterface service;

    @Autowired
    public UserController(UserServiceInterface service) {
        this.service = service;
    }

    @GetMapping("/{userId}")
    public Optional<User> findById(@PathVariable Long userId){
        return service.findById(userId);
    }

    @GetMapping
    public List<User> findAll(@RequestParam(value = "accelerationName", required = false) String name,
                              @RequestParam(value = "companyId", required = false) Long companyId){
        return Objects.nonNull(companyId)? findByCompanyId(companyId) : findByAccelerationName(name);
    }

    public List<User> findByAccelerationName(String name){
        return service.findByAccelerationName(name);
    }

    public List<User> findByCompanyId(Long companyId){
        return service.findByCompanyId(companyId);
    }
}
