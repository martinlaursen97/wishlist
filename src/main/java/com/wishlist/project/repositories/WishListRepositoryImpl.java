package com.wishlist.project.repositories;

import com.wishlist.project.domain.models.WishList;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class WishListRepositoryImpl implements WishListRepository {

    private final Connection connection = DBManager.getConnection();

    @Override
    public void createWishList(WishList wishList) {
        try {
            String query = "insert into sql11448324.wishlist(name,notes,code) values (?, ?, ?)";
            PreparedStatement preparedStatement;

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, wishList.getName());
            preparedStatement.setString(2, wishList.getNotes());
            preparedStatement.setString(3, wishList.getCode());
            preparedStatement.executeUpdate();

        } catch (Exception ignore) {

        }
    }

    @Override
    public List<WishList> getWishLists(long id) {
        List<WishList> wishLists = new ArrayList<>();
        try {
            String query = "SELECT * FROM sql11448324.wishlist WHERE user_id = " + id;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                WishList wishList = new WishList();
                wishList.setId(resultSet.getLong("wishlist_id"));
                wishList.setUserId(resultSet.getLong("user_id"));
                wishList.setName(resultSet.getString("name"));
                wishList.setNotes(resultSet.getString("notes"));
                wishList.setCode(resultSet.getString("code"));
                wishLists.add(wishList);
            }
        } catch (SQLException ignore) {

        }
        return wishLists;
    }
}

