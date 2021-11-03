package com.wishlist.project.repositories;

import com.wishlist.project.domain.models.WishList;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishListRepository {

    void createWishList(WishList wishList);
    List<WishList> getWishLists(long id);
}
