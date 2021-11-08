package com.wishlist.project.repositories;

import com.wishlist.project.domain.models.Item;
import com.wishlist.project.domain.models.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository {
    void createItem(Item item);
    void reserveItemById(long id);
    List<Item> getReservedItemsById(long id);
    Item getItemById(long id);
    User getUserByItemId(long id);
    void unreserveItemById(long id);
}
