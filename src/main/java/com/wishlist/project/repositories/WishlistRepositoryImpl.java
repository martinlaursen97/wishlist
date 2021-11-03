package com.wishlist.project.repositories;

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
            String query = "insert into sql11448324.wishlist(user_id,name,notes,code,creation_date) values (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement;

            System.out.println(wishlist.getUserId());
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
            String query = "SELECT * FROM sql11448324.wishlist WHERE user_id = " + id;
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
            String query = "DELETE FROM sql11448324.wishlist WHERE user_id = " + id;
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
            String query = "SELECT * FROM sql11448324.wishlist WHERE wishlist_id = " + id;
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
}

