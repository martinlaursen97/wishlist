package com.wishlist.project.controllers;

import com.wishlist.project.domain.models.Item;
import com.wishlist.project.domain.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController (ItemService itemService){
        this.itemService = itemService;
    }
//LOL
    @GetMapping("/createItem")
    public String createItem(){
        String name = "test";
        long wishListId = 12345678;
        String imageUrl = "url";
        double price = 1.3;
        String location = "Dk";
        String notes = "fedt";
        itemService.createItem(name, wishListId, imageUrl, price, location, notes);

        return "index";
    }

    @GetMapping("/reservedItems")
    public String reservedItems() {
        return "reservedItems";
    }
}
