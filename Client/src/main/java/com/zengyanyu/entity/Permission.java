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
 * 权限
 *
 * @author zengyanyu
 * @since 2025-08-08
 */
@Getter
@Setter
@Entity
@TableName("permission")
@ApiModel(value = "Permission对象", description = "权限")
public class Permission implements Serializable {

    @Id
    @ApiModelProperty("主键ID")
    private String id;

    @ApiModelProperty("方法名称")
    private String methodName;

    @ApiModelProperty("API操作名称")
    private String apiOperationName;

    @ApiModelProperty("请求方法")
    private String requestMethod;

    @ApiModelProperty("路径")
    private String path;

}
