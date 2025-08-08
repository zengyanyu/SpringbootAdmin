package com.zengyanyu.service;

import com.zengyanyu.commons.ResponseData;
import com.zengyanyu.entity.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 用户信息 服务类
 *
 * @author zengyanyu
 * @since 2025-07-29
 */
public interface IUserInfoService extends IService<UserInfo> {

    /**
     * 保存或更新用户信息
     *
     * @param userInfo 用户信息
     * @return
     */
    ResponseData saveOrUpdateUserInfo(UserInfo userInfo);

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名称，手机号码
     * @return
     */
    ResponseData<UserInfo> getUserInfoByUsername(String username);

    /**
     * 根据用户名称加载用户
     *
     * @param username 用户名称
     * @return
     */
    UserDetails loadUserByUsername(String username);
}
