package com.wishlist.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/")
    public String index1() {
        return "index";
    }

    @GetMapping("/test")
    public String index2() {
        return "index";
    }
}
