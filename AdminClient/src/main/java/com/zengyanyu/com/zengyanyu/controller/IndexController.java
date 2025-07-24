package com.zengyanyu.com.zengyanyu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("/toIndex")
    public String toIndex() {
        return "Index";
    }
}
