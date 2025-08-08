package com.zengyanyu.service;

import com.zengyanyu.commons.ResponseData;
import com.zengyanyu.entity.Permission;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 权限 服务类
 *
 * @author zengyanyu
 * @since 2025-08-08
 */
public interface IPermissionService extends IService<Permission> {

    /**
     * 保存或更新权限
     *
     * @param permission 权限
     * @return
     */
    ResponseData saveOrUpdatePermission(Permission permission);

    /**
     * 加载权限记录
     *
     * @return
     */
    ResponseData loadPermissionRecord();

}
