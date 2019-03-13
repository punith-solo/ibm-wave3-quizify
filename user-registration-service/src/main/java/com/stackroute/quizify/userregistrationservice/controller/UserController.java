package com.stackroute.quizify.userregistrationservice.controller;

import com.stackroute.quizify.userregistrationservice.domain.User;
import com.stackroute.quizify.userregistrationservice.exceptions.UserAlreadyExistException;
import com.stackroute.quizify.userregistrationservice.exceptions.UserNameExistException;
import com.stackroute.quizify.userregistrationservice.exceptions.UserNotFoundException;


import com.stackroute.quizify.userregistrationservice.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin (value = "*")
@RestController
@RequestMapping(value = "/api/v1")
@Api(description = "shows the user information")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @ApiOperation(value = "Accepts user into the repository")
    @PostMapping("/user")
    public ResponseEntity<?> saveUser(@RequestBody User user) throws UserAlreadyExistException, UserNameExistException {

        return new ResponseEntity<User>(this.userService.saveUser(user), HttpStatus.CREATED);
    }

    @ApiOperation(value = "returns user from the repository")
    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") long id) throws UserNotFoundException {
        return new ResponseEntity<User>(this.userService.getUser(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Accepts user into the repository")
    @GetMapping("/users")
    public ResponseEntity<?> getAllUser() throws UserNotFoundException {
        return new ResponseEntity<List<User>>(this.userService.getAllUsers(), HttpStatus.OK);
    }

    @ApiOperation(value = "Updates user into the repository")
    @PutMapping("/user")
    public ResponseEntity<?> UpdateUser(@RequestBody User user) throws UserNotFoundException, UserNameExistException {

        return new ResponseEntity<User>( this.userService.updateUser(user), HttpStatus.CREATED);

    }
    @ApiOperation(value = "Removes the user into the repository")
    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> getDeleteUser(@PathVariable Long id) throws UserNotFoundException{

         return new ResponseEntity<User>(userService.deleteUser(id), HttpStatus.NOT_FOUND);

    }
}

