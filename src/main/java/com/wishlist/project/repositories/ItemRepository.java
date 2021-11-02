package com.wishlist.project.repositories;

import com.wishlist.project.domain.models.Item;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository {
    void createItem(Item item);

}
