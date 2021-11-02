package com.wishlist.project.repositories;

import com.wishlist.project.domain.models.WishList;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
}

