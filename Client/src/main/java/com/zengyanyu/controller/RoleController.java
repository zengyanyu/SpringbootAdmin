package com.zengyanyu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zengyanyu.commons.ResponseData;
import com.zengyanyu.config.LogRecord;
import com.zengyanyu.entity.Role;
import com.zengyanyu.service.IRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zengyanyu
 * @since 2025-07-29
 */
@RestController
@Api(tags = "角色控制器")
@RequestMapping("/role")
public class RoleController extends BaseController {

    @Resource
    private IRoleService roleService;

    @LogRecord("保存或更新角色")
    @ApiOperation("保存或更新角色")
    @PostMapping("/save")
    public ResponseData save(@RequestBody Role role) {
        return roleService.saveOrUpdateRole(role);
    }

    @LogRecord("删除角色")
    @ApiOperation("删除角色")
    @GetMapping("/{id}")
    public ResponseData delete(@PathVariable String id) {
        roleService.removeById(id);
        return new ResponseData("删除成功");
    }

    @LogRecord("批量删除角色")
    @ApiOperation("批量删除角色")
    @PostMapping("/del/batch")
    public ResponseData deleteBatch(@RequestBody List<String> ids) {
        roleService.removeByIds(ids);
        return new ResponseData("批量删除成功");
    }

    @LogRecord("查询所有数据")
    @ApiOperation("查询所有数据")
    @GetMapping("/findAll")
    public ResponseData<List<Role>> findAll() {
        return new ResponseData("根据ID查询指定数据", roleService.list());
    }

    @LogRecord("根据ID查询指定数据")
    @ApiOperation("根据ID查询指定数据")
    @GetMapping("/get/{id}")
    public ResponseData<Role> get(@PathVariable String id) {
        return new ResponseData("根据ID查询指定数据", roleService.getById(id));
    }

    @LogRecord("角色分页查询数据")
    @ApiOperation("角色分页查询数据")
    @GetMapping("/page")
    public Page<Role> page(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        QueryWrapper<Role> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");
        return roleService.page(new Page<>(pageNum, pageSize), wrapper);
    }
}

