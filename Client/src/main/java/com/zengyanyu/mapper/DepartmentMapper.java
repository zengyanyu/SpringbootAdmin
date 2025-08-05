package com.zengyanyu.mapper;

import com.zengyanyu.entity.Department;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 部门管理 Mapper 接口
 *
 * @author zengyanyu
 * @since 2025-07-29
 */
@Mapper
public interface DepartmentMapper extends BaseMapper<Department> {

}
