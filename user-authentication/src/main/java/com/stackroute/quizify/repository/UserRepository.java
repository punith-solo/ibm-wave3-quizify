package com.stackroute.quizify.repository;

import com.stackroute.quizify.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String>
{

    public User findByUsernameAndPassword(String username,String password);
}
