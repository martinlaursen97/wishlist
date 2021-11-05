package com.wishlist.project.controllers;

import com.wishlist.project.domain.models.User;
import com.wishlist.project.domain.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("registerVerify")
    public String registerVerify(WebRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String street = request.getParameter("street");
        String city = request.getParameter("city");
        String zip = request.getParameter("zip");

        System.out.println("here");
        System.out.println(username);

        if (username == null ||
            password == null) {
            return "register";
        }

        if (!userService.usernameTaken(username)) {
            userService.createUser(username, password, email, phone, street, city, zip);
            System.out.println("here2");
            return "login";
        }

        return "register";
    }

    @PostMapping("loginVerify")
    public String loginVerify(WebRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (userService.loginValid(username, password)) {
            User user = userService.findByUsername(username);
            request.setAttribute("user", user, WebRequest.SCOPE_SESSION);
            request.setAttribute("id", user.getId(), WebRequest.SCOPE_SESSION);
            return "redirect:/wishlists";
        }

        return "login";
    }
}
