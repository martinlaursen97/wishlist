package com.wishlist.project.domain.services;

import com.wishlist.project.domain.models.WishList;
import com.wishlist.project.repositories.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WishListService {

    private final WishListRepository wishListRepository;

    @Autowired
    public WishListService(WishListRepository wishListRepository) {
        this.wishListRepository = wishListRepository;
    }


    public void createWishList(String name, String notes, String code) {
        WishList wishList = new WishList(name, notes, code);
        wishListRepository.createWishList(wishList);
    }
}
