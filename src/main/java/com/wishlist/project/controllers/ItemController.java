package com.wishlist.project.controllers;

import com.wishlist.project.domain.models.Item;
import com.wishlist.project.domain.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@Controller
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/reservedItems")
    public String reservedItems(Model model, WebRequest request) {
        long id = (long) request.getAttribute("id", WebRequest.SCOPE_SESSION);
        List<Item> reservedItems = itemService.getReservedItemsById(id);
        model.addAttribute("items", reservedItems);
        return "reservedItems";
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
        long id = (long) request.getAttribute("wishlistId", WebRequest.SCOPE_SESSION);

        itemService.createItem(name, id, imageUrl, price, location, notes);
        request.removeAttribute("wishlistId", WebRequest.SCOPE_SESSION);
        return "redirect:/wishlists";
    }

    @GetMapping("/reserve")
    public String reserveItem(@RequestParam String id, WebRequest request) {
        if (request.getAttribute("user", WebRequest.SCOPE_SESSION) != null) {
            itemService.reserveItemById(Long.parseLong(id));
            return "reservedSuccess";
        } else {
            return "reservedNotLoggedIn";
        }
    }

    @GetMapping("/unreserve")
    public String unReserveItem(@RequestParam String id) {
        itemService.unreserveItemById(Long.parseLong(id));
        return "unreservedSuccess";
    }

    @GetMapping("inspectItem")
    public String inspectItem(@RequestParam String id, Model model) {
        model.addAttribute("item", itemService.getItemById(Long.parseLong(id)));
        model.addAttribute("recipient", itemService.getUserByItemId(Long.parseLong(id)));
        return "inspectItem";
    }
}