package com.stackroute.quizify.jwt;

import com.stackroute.quizify.domain.User;

import java.util.Map;
@FunctionalInterface
public interface SecurityTokenGenrator
{


    Map<String, String> generateToken(User user);
}
