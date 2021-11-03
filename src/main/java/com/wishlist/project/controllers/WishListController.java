package com.wishlist.project.controllers;

import com.wishlist.project.domain.models.User;
import com.wishlist.project.domain.services.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

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

    @GetMapping("/wishlists")
    public String wishLists(Model model, WebRequest request) {
        long id = (long) request.getAttribute("id", WebRequest.SCOPE_SESSION);
        model.addAttribute("wishlists", wishListService.getWishLists(id));
        return "wishlists";
    }
}
