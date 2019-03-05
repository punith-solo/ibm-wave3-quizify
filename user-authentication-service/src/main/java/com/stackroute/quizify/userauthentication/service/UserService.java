package com.stackroute.quizify.userauthentication.service;

import com.stackroute.quizify.userauthentication.domain.LoginUser;
import com.stackroute.quizify.userauthentication.exceptions.UserNameNotFoundException;

import java.util.List;

public interface UserService
{
    public LoginUser saveUser(LoginUser user) throws UserNameNotFoundException; //user ADDED

    public List<LoginUser> getAllUsers();  ///RETRIEVE user

    public LoginUser findByUserIdAndPassword(String username,String password);
}
