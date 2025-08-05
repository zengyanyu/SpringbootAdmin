package com.zengyanyu.service.impl;

import com.zengyanyu.commons.ResponseData;
import com.zengyanyu.entity.Role;
import com.zengyanyu.mapper.RoleMapper;
import com.zengyanyu.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 角色 服务实现类
 *
 * @author zengyanyu
 * @since 2025-07-29
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    /**
     * 保存或更新角色
     *
     * @param role 角色
     * @return
     */
    @Override
    public ResponseData saveOrUpdateRole(Role role) {
        this.saveOrUpdate(role);
        return new ResponseData("保存或更新成功");
    }

}
