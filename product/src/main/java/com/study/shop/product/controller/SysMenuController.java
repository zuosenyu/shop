package com.study.shop.product.controller;

import com.study.shop.domain.R;
import com.study.shop.product.entity.SysMenu;
import com.study.shop.product.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: zuosy
 * @date 2021/11/11 9:53
 */
@RestController
@RequestMapping("/sysMenu")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;

    @GetMapping("/getTree")
    public R<List<SysMenu>> getTree(){
        return R.ok(sysMenuService.getMenuTree());
    }
}
