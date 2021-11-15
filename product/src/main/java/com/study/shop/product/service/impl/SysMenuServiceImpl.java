package com.study.shop.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.shop.product.entity.SysMenu;
import com.study.shop.product.mapper.SysMenuMapper;
import com.study.shop.product.service.SysMenuService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: zuosy
 * @date 2021/11/10 17:33
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {
    @Override
    public List<SysMenu> getMenuTree() {
        List<SysMenu> list = baseMapper.selectList(null);
        List<SysMenu> collect = list.stream().filter(sysMenu ->
                sysMenu.getParentId() == 0
        ).map(sysMenu -> {
            sysMenu.setChildren(getChildren(sysMenu,list));
            return sysMenu;
        }).sorted(Comparator.comparingInt(sysMenu ->
                Integer.parseInt(sysMenu.getOrderNum())
        )).collect(Collectors.toList());


        return collect;
    }

    private List<SysMenu> getChildren(SysMenu sysMenu,List<SysMenu> list){
        List<SysMenu> collect = list.stream().filter(sysMenu1 ->
                sysMenu1.getParentId() == sysMenu.getMenuId()
        ).map(sysMenu1 -> {
            sysMenu1.setChildren(getChildren(sysMenu1, list));
            return sysMenu1;
        }).sorted(Comparator.comparingInt(sysMenu1 ->
                Integer.parseInt(sysMenu1.getOrderNum())
        )).collect(Collectors.toList());
        return collect;
    }

}
