package com.wishlist.project.controllers;

import com.wishlist.project.domain.services.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WishListController {

    private final WishListService wishListService;

    @Autowired
    public WishListController(WishListService wishListService) {
        this.wishListService = wishListService;
    }

    @GetMapping("/test")
    public String createWishList() {
        String name = "test1";
        String code ="test1";
        String notes = "test1";
        wishListService.createWishList(name, notes, code);
        System.out.println("Her");
        return "index";
    }



}
