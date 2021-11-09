package com.wishlist.project.domain.services;

import com.wishlist.project.dto.ItemUserDTO;
import com.wishlist.project.domain.models.Item;
import com.wishlist.project.domain.models.User;
import com.wishlist.project.repositories.ItemRepository;
import com.wishlist.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository, UserRepository userRepository) {
        this.itemRepository = itemRepository;
       this.userRepository = userRepository;
    }

    public void createItem(String name, long wishListId, String imageUrl, double price, String location, String notes) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateNow = new Date();

        String dateStr = formatter.format(dateNow);
        Item item = new Item(name, wishListId, imageUrl, price, location, notes, dateStr);
        itemRepository.createItem(item);
    }


    public void reserveItemById(long id) {
        itemRepository.reserveItemById(id);
    }

    public List<Item> getReservedItemsById(long id) {
        return itemRepository.getReservedItemsById(id);
    }

    public Item getItemById(long id) {
        return itemRepository.getItemById(id);
    }

    public User getUserByItemId(long id) {
        return userRepository.getUserByItemId(id);
    }

    public void unreserveItemById(long id) {
        itemRepository.unreserveItemById(id);
    }

    public ItemUserDTO getItemInfoById(long id) {
        Item item = getItemById(id);
        User user = getUserByItemId(id);
        return new ItemUserDTO(item, user);
    }
}


