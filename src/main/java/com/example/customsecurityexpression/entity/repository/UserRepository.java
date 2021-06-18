package com.example.customsecurityexpression.entity.repository;

import com.example.customsecurityexpression.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Silauras
 * Created on 18.06.2021 at 13:31
 */
public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUsername(String username);
}
