package com.stackroute.quizify.recommendationservice.controller;

import com.stackroute.quizify.recommendationservice.domain.User;
import com.stackroute.quizify.recommendationservice.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/rest/neo4j/user")

@Api(description = "Operations on User Nodes")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation("Get all users")
    @GetMapping("/")
    public List<User> getAll(){
        return userService.getAll();
    }

    @ApiOperation("Get user by id")
    @GetMapping("/id")
    public User getOne(@RequestParam("userId") long userId){
        return userService.getone(userId);
    }

    @ApiOperation("Create user")
    @PostMapping("/")
    public User create(@RequestBody User user){
        return userService.create(user);
    }

    @ApiOperation("Delete user")
    @DeleteMapping("/")
    public User delete(@RequestParam("userId") long userId){
        System.out.println(userId);
        return userService.delete(userId);
    }

    @ApiOperation("Update user")
    @PutMapping("/")
    public User update(@RequestBody User user)
    {
        return userService.update(user);
    }

}
