package com.wishlist.project.domain.services;

import com.wishlist.project.domain.models.Item;
import com.wishlist.project.domain.models.User;
import com.wishlist.project.repositories.ItemRepository;
import com.wishlist.project.repositories.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void createItem(String name, long wishListId, String imageUrl, double price, String location, String notes) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateNow = new Date();

        String dateStr = formatter.format(dateNow);
        Item item = new Item(name, wishListId, imageUrl, price, location, notes, dateStr);
        itemRepository.createItem(item);
    }


}


