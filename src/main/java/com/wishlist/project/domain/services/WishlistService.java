package com.wishlist.project.domain.services;

import com.wishlist.project.domain.dto.SharedDTO;
import com.wishlist.project.domain.models.Item;
import com.wishlist.project.domain.models.User;
import com.wishlist.project.domain.models.Wishlist;
import com.wishlist.project.repositories.ItemRepository;
import com.wishlist.project.repositories.UserRepository;
import com.wishlist.project.repositories.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class WishlistService {

    private final WishlistRepository wishlistRepository;
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;

    @Autowired
    public WishlistService(WishlistRepository wishlistRepository, UserRepository userRepository, ItemRepository itemRepository) {
        this.wishlistRepository = wishlistRepository;
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
    }
    public void createWishlist(long id, String name, String notes) {
        String code = wishlistRepository.generateCode();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateNow = new Date();
        String dateStr = formatter.format(dateNow);

        Wishlist wishList = new Wishlist(id, name, notes, code, dateStr);
        wishlistRepository.createWishlist(wishList);
    }

    public SharedDTO getWishlistInfoByCode(String code) {
        Wishlist wishlist = findWishlistByCode(code);
        long id = wishlist.getId();
        User user = userRepository.findByUsername(getNameById(id));
        List<Item> items = itemRepository.findNotReservedItemsByWishlistId(id);
        int size = itemRepository.getWishlistSizeById(id);
        return new SharedDTO(wishlist, user, items, size);
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
        return userRepository.getNameById(userId);
    }

    public List<Item> getItemsByWishlistId(long id) {
        return itemRepository.getItemsByWishlistId(id);
    }
}
