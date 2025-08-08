package com.zengyanyu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户信息
 *
 * @author zengyanyu
 * @since 2025-07-29
 */
@Getter
@Setter
@Entity
@TableName("user_info")
@ApiModel(value = "UserInfo对象", description = "用户信息")
public class UserInfo implements Serializable {

    @Id
    private String id;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("token")
    private String token;

}
