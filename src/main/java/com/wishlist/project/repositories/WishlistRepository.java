package com.wishlist.project.repositories;

import com.wishlist.project.domain.models.Item;
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
    String getNameById(long userId);
    String generateCode();
    List<Item> findNotReservedItemsById(long id);
    int getWishlistSizeById(long id);

    List<Item> getItemsByWishlistId(long id);
}
