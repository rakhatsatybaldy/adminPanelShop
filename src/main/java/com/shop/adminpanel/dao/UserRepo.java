package com.shop.adminpanel.dao;

import com.shop.adminpanel.model.UserRoleUsers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserRoleUsers , Long> {
}
