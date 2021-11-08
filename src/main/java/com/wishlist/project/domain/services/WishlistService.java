package com.wishlist.project.domain.services;

import com.wishlist.project.domain.models.Item;
import com.wishlist.project.domain.models.Wishlist;
import com.wishlist.project.repositories.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class WishlistService {

    private final WishlistRepository wishlistRepository;

    @Autowired
    public WishlistService(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }


    public void createWishlist(long id, String name, String notes) {
        String code = wishlistRepository.generateCode();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateNow = new Date();
        String dateStr = formatter.format(dateNow);

        Wishlist wishList = new Wishlist(id, name, notes, code, dateStr);
        wishlistRepository.createWishlist(wishList);
    }

    public List<Wishlist> getWishlists(long id) {
        return wishlistRepository.getWishlists(id);
    }

    public void clearWishlistsById(long id) {
        wishlistRepository.clearWishlistsById(id);
    }

    public Wishlist findWishlistById(long id) {
        return wishlistRepository.findWishlistById(id);
    }

    public void clearWishlistById(long id) {
        wishlistRepository.clearWishlistById(id);
    }

    public Wishlist findWishlistByCode(String code) {
        return wishlistRepository.findWishlistByCode(code);
    }

    public String getNameById(long userId) {
        return wishlistRepository.getNameById(userId);
    }

    public List<Item> findNotReservedItemsById(long id) {
        return wishlistRepository.findNotReservedItemsById(id);
    }

    public int getWishlistSizeById(long id) {
        return wishlistRepository.getWishlistSizeById(id);
    }

    public List<Item> getItemsByWishlistId(long id) {
        return wishlistRepository.getItemsByWishlistId(id);
    }
}
