package com.zengyanyu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@TableName("log_record_entity")
@ApiModel(value = "日志记录实体", description = "日志记录实体")
public class LogRecordEntity implements Serializable {

    @Id
    @ApiModelProperty("日志唯一标识")
    private String id;

    @Comment("操作名称")
    @ApiModelProperty("操作名称")
    private String operateName;

    @Comment("操作账号")
    @ApiModelProperty("操作账号")
    private String operateUsername;

    @Comment("请求路径")
    @ApiModelProperty("请求路径")
    private String path;

    @Comment("请求方式")
    @ApiModelProperty("请求方式")
    private String method;

    @Comment("请求IP地址")
    @ApiModelProperty("请求IP地址")
    private String requestIp;

    @Comment("全限定类名称")
    @ApiModelProperty("全限定类名称")
    private String qualifiedName;

    @Comment("请求入参")
    @Type(type = "text")
    @Column(columnDefinition = "TEXT")
    @ApiModelProperty("请求入参")
    private String inputParam;

    @Comment("请求出参")
    @ApiModelProperty("请求出参")
    private String outputParam;

    @Comment("异常信息")
    @Type(type = "text")
    @Column(columnDefinition = "TEXT")
    @ApiModelProperty("异常信息")
    private String errorMsg;

    @Comment("请求开始时间")
    @ApiModelProperty("请求开始时间")
    private LocalDateTime requestTime;

    @Comment("请求响应时间")
    @ApiModelProperty("请求响应时间")
    private LocalDateTime responseTime;

    @Comment("请求是否成功")
    @ApiModelProperty("请求是否成功")
    private String status;

}
