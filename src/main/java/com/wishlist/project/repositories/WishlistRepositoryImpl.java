package com.wishlist.project.repositories;

import com.wishlist.project.domain.models.Item;
import com.wishlist.project.domain.models.User;
import com.wishlist.project.domain.models.Wishlist;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class WishlistRepositoryImpl implements WishlistRepository {

    private final Connection connection = DBManager.getConnection();

    @Override
    public void createWishlist(Wishlist wishlist) {
        try {
            String query = "insert into sql11449169.wishlist(user_id,name,notes,code,creation_date) values (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement;

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, wishlist.getUserId());
            preparedStatement.setString(2, wishlist.getName());
            preparedStatement.setString(3, wishlist.getNotes());
            preparedStatement.setString(4, wishlist.getCode());
            preparedStatement.setString(5, wishlist.getDate());
            preparedStatement.executeUpdate();

        } catch (Exception ignore) {

        }
    }

    @Override
    public List<Wishlist> getWishlists(long id) {
        List<Wishlist> wishlists = new ArrayList<>();
        try {
            String query = "SELECT * FROM sql11449169.wishlist WHERE user_id = " + id + " ORDER BY wishlist_id DESC";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                Wishlist wishList = new Wishlist();
                wishList.setId(resultSet.getLong("wishlist_id"));
                wishList.setUserId(resultSet.getLong("user_id"));
                wishList.setName(resultSet.getString("name"));
                wishList.setNotes(resultSet.getString("notes"));
                wishList.setCode(resultSet.getString("code"));
                wishList.setDate(resultSet.getString("creation_date"));
                wishlists.add(wishList);
            }
        } catch (SQLException ignore) {

        }
        return wishlists;
    }

    @Override
    public void clearWishlistsById(long id) {
        try {
            String query = "DELETE FROM sql11449169.wishlist WHERE user_id = " + id;
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
        } catch (Exception ignore) {

        }
    }

    @Override
    public Wishlist findWishlistById(long id) {
        Wishlist wishlist = new Wishlist();

        try {
            String query = "SELECT * FROM sql11449169.wishlist WHERE wishlist_id = " + id;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            wishlist.setId(resultSet.getLong("wishlist_id"));
            wishlist.setUserId(resultSet.getLong("user_id"));
            wishlist.setName(resultSet.getString("name"));
            wishlist.setNotes(resultSet.getString("notes"));
            wishlist.setCode(resultSet.getString("code"));
            wishlist.setDate(resultSet.getString("creation_date"));
        } catch (SQLException ignore) {

        }

        return wishlist;
    }

    @Override
    public void clearWishlistById(long id) {
        try {
            String query = "DELETE FROM sql11449169.wishlist WHERE wishlist_id = " + id;
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
        } catch (Exception ignore) {

        }
    }

    @Override
    public Wishlist findWishlistByCode(String code) {
        Wishlist wishlist = new Wishlist();

        try {
            String query = "SELECT * FROM sql11449169.wishlist WHERE code = '" + code  + "'";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            wishlist.setId(resultSet.getLong("wishlist_id"));
            wishlist.setUserId(resultSet.getLong("user_id"));
            wishlist.setName(resultSet.getString("name"));
            wishlist.setNotes(resultSet.getString("notes"));
            wishlist.setCode(resultSet.getString("code"));
            wishlist.setDate(resultSet.getString("creation_date"));
        } catch (SQLException ignore) {

        }

        return wishlist;
    }

    @Override
    public List<Item> findNotReservedItemsById(long id) {
        List<Item> items = new ArrayList<>();
        try {
            String query = "SELECT * FROM sql11449169.item WHERE wishlist_id = " + id + " AND reserved = false";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                Item item = new Item();
                item.setId(resultSet.getLong("item_id"));
                item.setName(resultSet.getString("name"));
                item.setWishListId(resultSet.getLong("wishlist_id"));
                item.setImageUrl(resultSet.getString("image_url"));
                item.setPrice(resultSet.getDouble("price"));
                item.setLocation(resultSet.getString("location"));
                item.setNotes(resultSet.getString("notes"));
                item.setReserved(resultSet.getBoolean("reserved"));
                item.setDate(resultSet.getString("creation_date"));
                items.add(item);
            }
        } catch (SQLException ignore) {

        }
        return items;
    }



    @Override
    public int getWishlistSizeById(long id) {
        int size = 0;

        try {
            String query = "SELECT count(*) FROM sql11449169.item WHERE wishlist_id = " + id;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            size = resultSet.getInt(1);

        } catch (SQLException ignore) {

        }
        return size;
    }

    @Override
    public String getNameById(long userId) {
        String name = null;

        try {
            String query = "SELECT username FROM sql11449169.user WHERE user_id = " + userId;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            name = resultSet.getString("username");

        } catch (SQLException ignore) {

        }

        return name;
    }

    @Override
    public String generateCode() {
        String code = null;

        try {
            String query = "SELECT LEFT(UUID(), 8)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            code = resultSet.getString(1);

        } catch (SQLException ignore) {

        }
        return code;
    }
}

