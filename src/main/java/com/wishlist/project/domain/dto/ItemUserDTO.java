package com.wishlist.project.domain.dto;

import com.wishlist.project.domain.models.Item;
import com.wishlist.project.domain.models.User;

public class ItemUserDTO {
    private Item item;
    private User user;

    public ItemUserDTO(Item item, User user) {
        this.item = item;
        this.user = user;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
