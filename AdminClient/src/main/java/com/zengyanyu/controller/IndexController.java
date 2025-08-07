package com.zengyanyu.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Index控制器")
@RestController
public class IndexController {

    @ApiOperation("返回Index")
    @GetMapping("/toIndex")
    public String toIndex() {
        return "Index";
    }
}
