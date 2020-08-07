package com.shop.adminpanel.controller;


import com.shop.adminpanel.dao.ProductDao;
import com.shop.adminpanel.dao.UserRepo;
import com.shop.adminpanel.exception.ProductNotFoundException;
import com.shop.adminpanel.model.Product;
import com.shop.adminpanel.model.UserRoleUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class MainController {

//    private List<Product> products = new ArrayList<>();
//    private List<UserRoleUsers> simpleUsers = new ArrayList<>();

    @Autowired
    private ProductDao productDao;

    @Autowired
    private UserRepo userRepo;



    @GetMapping("/products")
    List<Product> all(){
        return productDao.findAll();
    }

    @PostMapping("/addProduct")
    Product addNewProduct(@RequestBody Product product){
        return productDao.save(product);
    }

    @GetMapping("/product/{id}")
    Product one(@PathVariable Long id){
        return productDao.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    @PutMapping("/product/{id}")
    Product replaceProduct(@RequestBody Product newProduct , @PathVariable Long id){
        return productDao.findById(id)
                .map(product -> {
                            product.setName(newProduct.getName());
                            product.setPrice(newProduct.getPrice());
                            return productDao.save(product);
                })
                .orElseGet(() -> {
                    newProduct.setId(id);
                    return productDao.save(newProduct);
                });

    }

    @DeleteMapping("/product/{id}")
    void deleteProduct(@PathVariable Long id){
        productDao.deleteById(id);
    }

    @GetMapping("/user/{id}")
    Optional<UserRoleUsers> getOne(@PathVariable Long id){
        return userRepo.findById(id);
    }

    @PutMapping("/user/{id}")
        UserRoleUsers updateUsers(@RequestBody UserRoleUsers newUser , @PathVariable Long id){


        return userRepo.findById(id)
                .map(userRoleUsers -> {
                    userRoleUsers.setBlocked(newUser.isBlocked());
                    return userRepo.save(userRoleUsers);
                })
                .orElseGet(() ->{
                    newUser.setId(id);
                    return userRepo.save(newUser);
                });


        }

        @GetMapping("/users")
    List<UserRoleUsers> getAll(){
            return userRepo.findAll();
        }

    @DeleteMapping("/user/{id}")
    void deleteUser(@PathVariable Long id){
        userRepo.deleteById(id);
    }



}