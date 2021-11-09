package com.wishlist.project.domain.dto;

import com.wishlist.project.domain.models.Item;
import com.wishlist.project.domain.models.User;
import com.wishlist.project.domain.models.Wishlist;

import java.util.List;

public class SharedDTO {
    private Wishlist wishlist;
    private User user;
    private List<Item> items;
    private int size;

    public SharedDTO(Wishlist wishlist, User user, List<Item> items, int size) {
        this.wishlist = wishlist;
        this.user = user;
        this.items = items;
        this.size = size;
    }

    public Wishlist getWishlist() {
        return wishlist;
    }

    public void setWishlist(Wishlist wishlist) {
        this.wishlist = wishlist;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int size() {
        return size;
    }
}
