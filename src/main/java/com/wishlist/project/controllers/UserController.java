package com.wishlist.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class UserController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("registerVerify")
    public String registerVerify(WebRequest request) {
        System.out.println(request.getParameter("username"));
        System.out.println(request.getParameter("password"));
        System.out.println(request.getParameter("email"));
        System.out.println(request.getParameter("phone"));
        System.out.println(request.getParameter("street"));
        System.out.println(request.getParameter("city"));
        System.out.println(request.getParameter("zip"));
        return "register";
    }

    @PostMapping("loginVerify")
    public String loginVerify(WebRequest request) {
        System.out.println(request.getParameter("username"));
        System.out.println(request.getParameter("password"));
        return "login";
    }
}
