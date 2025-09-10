package org.example.demo2.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "这是一个需要登录才能访问的普通接口";
    }

    @GetMapping("/admin/test")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminTest() {
        return "这是一个需要ADMIN角色才能访问的接口";
    }

    @GetMapping("/public/test")
    public String publicTest() {
        return "这是一个公开接口，无需认证即可访问";
    }
}
