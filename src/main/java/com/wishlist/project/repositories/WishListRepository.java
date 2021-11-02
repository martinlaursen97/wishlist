package com.wishlist.project.repositories;

import com.wishlist.project.domain.models.WishList;
import org.springframework.stereotype.Repository;

@Repository
public interface WishListRepository {

    void createWishList(WishList wishList);



}
