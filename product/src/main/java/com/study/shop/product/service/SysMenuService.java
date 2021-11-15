package com.study.shop.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.study.shop.product.entity.SysMenu;

import java.util.List;

/**
 * @author: zuosy
 * @date 2021/11/10 17:32
 */
public interface SysMenuService extends IService<SysMenu> {


    List<SysMenu> getMenuTree();
}
