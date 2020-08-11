package com.learning.tkzc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 首页控制层
 *
 * @author tangjx
 * @date 2020/8/10 17:45
 */
@RestController
@RequestMapping("/V1")
public class IndexController {

    @GetMapping("/index")
    public Object goIndex() {
        return "index";
    }

}
