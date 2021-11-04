package com.wishlist.project.controllers;

import com.wishlist.project.domain.models.Item;
import com.wishlist.project.domain.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/createItem")
    public String createItem() {
        String name = "test";
        long wishListId = 12345678;
        String imageUrl = "url";
        double price = 1.3;
        String location = "Dk";
        String notes = "fedt";
        itemService.createItem(name, wishListId, imageUrl, price, location, notes);

        return "index";
    }

    @GetMapping("/addItem")
    public String addItem() {
        return "addItem";
    }

    @PostMapping("/addItemVerify")
    public String addItemVerify(WebRequest request) {
        String name = request.getParameter("name");
        String imageUrl = request.getParameter("imageUrl");
        double price = Double.parseDouble(request.getParameter("price"));
        String location = request.getParameter("location");
        String notes = request.getParameter("notes");
        itemService.createItem(name,1l,imageUrl,price,location,notes);
        return "wishlist";
    }
}
