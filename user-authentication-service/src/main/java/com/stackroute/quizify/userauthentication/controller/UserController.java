package com.stackroute.quizify.userauthentication.controller;
import com.stackroute.quizify.userauthentication.domain.User;
import com.stackroute.quizify.userauthentication.exceptions.PasswordNotMatchException;
import com.stackroute.quizify.userauthentication.exceptions.UserAlreadyExistsException;
import com.stackroute.quizify.userauthentication.exceptions.UserNameNotFoundException;
import com.stackroute.quizify.userauthentication.exceptions.UserNameOrPasswordEmptyException;
import com.stackroute.quizify.userauthentication.jwt.SecurityTokenGenrator;
import com.stackroute.quizify.userauthentication.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;

@Slf4j
@CrossOrigin(value = "*")
@RequestMapping("api")
@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Accept user into repository and generating token")
    @PostMapping("/user")
    public ResponseEntity<?>  login(@RequestBody User loginDetails) throws UserNameOrPasswordEmptyException, UserNameNotFoundException, PasswordNotMatchException {

        String username = loginDetails.getName();
        String password = loginDetails.getPassword();

        if (username == null || password == null) {

            throw new UserNameOrPasswordEmptyException();
        }

        User user = userService.findByUserIdAndPassword(username, password);

        if (user == null) {
            throw new UserNameNotFoundException();
        }

        String fetchedPassword = user.getPassword();

        if (!password.equals(fetchedPassword)) {
            throw new PasswordNotMatchException();
        }

        // generating token

        SecurityTokenGenrator securityTokenGenrator = (User userDetails) -> {
            String jwtToken = "";

            jwtToken = Jwts.builder().setId(""+user.getId()).setSubject(user.getRole()).setAudience(user.getName()).setIssuedAt(new Date())

                    .signWith(SignatureAlgorithm.HS256, "secretkey").compact();

            Map<String, String> map1 = new HashMap<>();

            map1.put("token", jwtToken);

            map1.put("message", "User successfully logged in");

            return map1;

        };
        Map<String, String> map = securityTokenGenrator.generateToken(user);
        return new ResponseEntity<>(map, HttpStatus.OK);

    }
    @ApiOperation(value = "Gets all the user details(username,password,role)")
    @GetMapping("/users")
    public ResponseEntity<?> getAllUser()
    {
        return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
    }

    @ApiOperation(value = "It saves all the user details")
    @PostMapping("/users/user")
    public ResponseEntity<?> saveEvent(@RequestBody User user) throws UserAlreadyExistsException {

        return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.OK);

    }



}
