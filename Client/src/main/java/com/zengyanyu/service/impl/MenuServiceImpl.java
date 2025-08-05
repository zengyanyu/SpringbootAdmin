package com.zengyanyu.service.impl;

import com.zengyanyu.commons.ResponseData;
import com.zengyanyu.entity.Menu;
import com.zengyanyu.mapper.MenuMapper;
import com.zengyanyu.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 菜单 服务实现类
 *
 * @author zengyanyu
 * @since 2025-07-29
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    /**
     * 保存或更新菜单
     *
     * @param menu 菜单
     * @return
     */
    @Override
    public ResponseData saveOrUpdateMenu(Menu menu) {
        this.saveOrUpdate(menu);
        return new ResponseData("保存或更新成功");
    }

}
