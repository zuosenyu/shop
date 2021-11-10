package com.study.shop.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: zuosy
 * @date 2021/11/10 14:13
 */
@FeignClient("product")
public interface ProductFeignService {

    @RequestMapping(value = "/product/getProductName", method = RequestMethod.GET)
    public String getProductName(@RequestParam("name") String name);
}
