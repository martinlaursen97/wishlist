package com.wishlist.project.controllers;

import com.wishlist.project.dto.SharedDTO;
import com.wishlist.project.domain.models.Wishlist;
import com.wishlist.project.domain.services.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@Controller
public class WishlistController {

    private final WishlistService wishlistService;

    @Autowired
    public WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    @GetMapping("/createWishlist")
    public String createWishList() {
        return "createWishlist";
    }

    @PostMapping("/createWishlistVerify")
    public String createWishlistVerify(WebRequest request) {
        long id = (long) request.getAttribute("id", WebRequest.SCOPE_SESSION);
        String name = request.getParameter("name");
        String notes = request.getParameter("notes");

        if (name == null || name.length() == 0) {
            return "createWishlist";
        }

        wishlistService.createWishlist(id, name, notes);
        return "redirect:/wishlists";
    }

    @GetMapping("/wishlists")
    public String wishlists(Model model, WebRequest request) {
        long id = (long) request.getAttribute("id", WebRequest.SCOPE_SESSION);
        model.addAttribute("wishlists", wishlistService.getWishlists(id));
        return "wishlists";
    }

    @GetMapping("/clearWishlists")
    public String clearWishlists() {
        return "clearWishlists";
    }

    @RequestMapping("/clearConfirmed")
    public String clearConfirmed(WebRequest request) {
        long id = (long) request.getAttribute("id", WebRequest.SCOPE_SESSION);
        wishlistService.clearWishlistsById(id);
        return "redirect:/wishlists";
    }

    @GetMapping("/removeWishlist")
    public String removeWishlist() {
        return "removeWishlist";
    }

    @RequestMapping("/removeWishlistConfirmed")
    public String removeWishlistConfirmed(WebRequest request) {
        long id = (long) request.getAttribute("wishlistId", WebRequest.SCOPE_SESSION);
        if (id != 0L) {
            wishlistService.clearWishlistById(id);
        }
        return "redirect:/wishlists";
    }

    @GetMapping("/wishlist")
    public String inspectWishlist(@RequestParam(name="id") String id, Model model, WebRequest request) {
        Wishlist wishlist = wishlistService.findWishlistById(Long.parseLong(id));
        model.addAttribute("items", wishlistService.getItemsByWishlistId(Long.parseLong(id)));
        model.addAttribute("wishlist", wishlist);
        long wishlistId = Long.parseLong(id);
        request.setAttribute("wishlistId", wishlistId, WebRequest.SCOPE_SESSION);
        return "wishlist";
    }

    @GetMapping("/view")
    public String wishlistShared(@RequestParam String code, Model model, WebRequest request) {
        SharedDTO wishlistInfo = wishlistService.getWishlistInfoByCode(code);

        model.addAttribute("wishlist", wishlistInfo.getWishlist());
        model.addAttribute("items", wishlistInfo.getItems());
        model.addAttribute("recipient", wishlistInfo.getUser());
        model.addAttribute("size", wishlistInfo.size());

        if (request.getAttribute("user", WebRequest.SCOPE_SESSION) != null) {
            return "wishlistSharedInSession";
        } else {
            return "wishlistSharedNotSession";
        }
    }
}
