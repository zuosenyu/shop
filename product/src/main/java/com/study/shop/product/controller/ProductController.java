package com.study.shop.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zuosy
 * @date 2021/11/10 14:16
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/getProductName")
    public String getProductName(@RequestParam("name") String name){
        return "product-" + name;
    }
}
