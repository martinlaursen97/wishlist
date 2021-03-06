package com.wishlist.project.repositories;

import com.wishlist.project.domain.models.Item;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository {

    void createItem(Item item);
    void reserveItemById(long itemId, long id);
    List<Item> getReservedItemsById(long id);
    Item getItemById(long id);
    void unreserveItemById(long id);
    List<Item> findNotReservedItemsByWishlistId(long id);
    List<Item> getItemsByWishlistId(long id);
    int getWishlistSizeById(long id);
    boolean itemReserved(long itemId);
}
