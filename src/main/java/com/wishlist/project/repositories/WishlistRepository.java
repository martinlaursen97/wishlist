package com.wishlist.project.repositories;

import com.wishlist.project.domain.models.Wishlist;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishlistRepository {

    void createWishlist(Wishlist wishList);
    List<Wishlist> getWishlists(long id);
    void clearWishlistsById(long id);
    Wishlist findWishlistById(long id);
    void clearWishlistById(long id);
    Wishlist findWishlistByCode(String code);
    String generateCode();
}
