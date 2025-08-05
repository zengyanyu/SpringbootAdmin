package com.zengyanyu.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 * 角色
 *
 * @author zengyanyu
 * @since 2025-07-29
 */
@Getter
@Setter
@Entity
@TableName("role")
@ApiModel(value = "Role对象", description = "角色")
public class Role implements Serializable {

    @Id
    private String id;

    private String roleName;

    @ApiModelProperty("角色编码")
    private String roleCode;

}
