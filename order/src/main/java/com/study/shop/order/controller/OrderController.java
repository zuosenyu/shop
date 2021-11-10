package com.study.shop.order.controller;

import com.study.shop.order.feign.ProductFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zuosy
 * @date 2021/11/10 14:13
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private ProductFeignService productFeignService;

    @GetMapping("/get")
    public String get(@RequestParam("name") String name){
        return productFeignService.getProductName(name);
    }
}
