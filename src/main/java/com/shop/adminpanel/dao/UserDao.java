package com.shop.adminpanel.dao;

import com.shop.adminpanel.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User , Long> {
    User findByUsername(String username);
}
