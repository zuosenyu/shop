package com.study.shop.order.controller;

import com.study.shop.order.entity.User;
import com.study.shop.order.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: zuosy
 * @date 2021/11/10 15:08
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public boolean save(@RequestBody User user){
        return userService.save(user);
    }


    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Long id){
        return userService.removeById(id);
    }
}
