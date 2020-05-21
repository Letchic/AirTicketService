package com.letchic.repository;

import com.letchic.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmailAndPassword(String email,String password);
}
