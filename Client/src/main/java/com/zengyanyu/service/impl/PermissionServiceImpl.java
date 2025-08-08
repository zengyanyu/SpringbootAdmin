package com.zengyanyu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zengyanyu.commons.ResponseData;
import com.zengyanyu.entity.Permission;
import com.zengyanyu.mapper.PermissionMapper;
import com.zengyanyu.service.IPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * 权限 服务实现类
 *
 * @author zengyanyu
 * @since 2025-08-08
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

    @Resource
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    /**
     * 保存或更新权限
     *
     * @param permission 权限
     * @return
     */
    @Override
    public ResponseData saveOrUpdatePermission(Permission permission) {
        this.saveOrUpdate(permission);
        return new ResponseData("保存或更新成功");
    }

    /**
     * 加载权限记录
     *
     * @return
     */
    @Override
    public ResponseData loadPermissionRecord() {
        // 获取所有注册的请求映射
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = requestMappingHandlerMapping.getHandlerMethods();
        for (Map.Entry<RequestMappingInfo, HandlerMethod> entry : handlerMethods.entrySet()) {
            HandlerMethod handlerMethod = entry.getValue();
            Class<?> beanType = handlerMethod.getBeanType();
            Method[] methods = beanType.getDeclaredMethods();
            for (Method method : methods) {
                // 方法路径前缀
                String methodPathPrefix = "";
                // 判断方式上是否有@RequestMapping注解
                if (method.getDeclaringClass().isAnnotationPresent(RequestMapping.class)) {
                    String[] value = method.getDeclaringClass().getAnnotation(RequestMapping.class).value();
                    methodPathPrefix = value[0];
                }
                // 判断方法上是否有@ApiOperation注解
                if (method.isAnnotationPresent(ApiOperation.class)) {
                    String className = method.getDeclaringClass().getName();
                    String methodName = method.getName();
                    String permissionName = className + ":" + methodName;

                    ApiOperation annotation = method.getAnnotation(ApiOperation.class);
                    String value = annotation.value();

                    QueryWrapper<Permission> wrapper = new QueryWrapper<>();
                    wrapper.eq("method_name", permissionName);
                    Permission permissionEntity = this.getOne(wrapper);
                    if (null == permissionEntity) {
                        // 创建对象，设置属性
                        Permission permission = new Permission();
                        permission.setMethodName(permissionName);
                        permission.setApiOperationName(value);

                        if (method.isAnnotationPresent(RequestMapping.class)) {
                            RequestMapping annotationRequestMapping = method.getAnnotation(RequestMapping.class);
                            RequestMethod[] method1 = annotationRequestMapping.method();
                            permission.setRequestMethod(method1[0].toString());
                            permission.setPath(methodPathPrefix + annotationRequestMapping.value()[0]);
                        }
                        if (method.isAnnotationPresent(GetMapping.class)) {
                            GetMapping annotationGetMapping = method.getAnnotation(GetMapping.class);
                            String[] value1 = annotationGetMapping.value();
                            permission.setRequestMethod("GET");
                            permission.setPath(methodPathPrefix + value1[0]);
                        }
                        if (method.isAnnotationPresent(PostMapping.class)) {
                            PostMapping annotationPostMapping = method.getAnnotation(PostMapping.class);
                            String[] value1 = annotationPostMapping.value();
                            permission.setRequestMethod("POST");
                            permission.setPath(methodPathPrefix + value1[0]);
                        }
                        this.save(permission);
                    }
                }
            }
        }
        return new ResponseData("加载权限记录成功");
    }

}
