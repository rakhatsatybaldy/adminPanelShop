package com.shop.adminpanel.dao;

import com.shop.adminpanel.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, Long> {
}
