package com.wishlist.project.domain.services;

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
        //String code = generateUniqueCode();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateNow = new Date();

        String dateStr = formatter.format(dateNow);

        String code = "123";
        Wishlist wishList = new Wishlist(id, name, notes, code, dateStr);

        System.out.println(id);
        wishlistRepository.createWishlist(wishList);
    }

    public List<Wishlist> getWishlists(long id) {
        return wishlistRepository.getWishlists(id);
    }
}
