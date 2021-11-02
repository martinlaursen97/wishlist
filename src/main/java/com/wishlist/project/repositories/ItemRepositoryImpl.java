package com.wishlist.project.repositories;

import com.wishlist.project.domain.models.Item;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;

@Repository
public class ItemRepositoryImpl implements ItemRepository{

    private final Connection connection = DBManager.getConnection();

    @Override
    public void createItem(Item item) {
        try {
            String query = "insert into sql11448324.item(name, wishlist_id, image_url, price, location, notes, reserved) values (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement;

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, item.getName());
            preparedStatement.setLong(2, item.getWishListId());
            preparedStatement.setString(3, item.getImageUrl());
            preparedStatement.setDouble(4, item.getPrice());
            preparedStatement.setString(5, item.getLocation());
            preparedStatement.setString(6, item.getNotes());
            preparedStatement.setBoolean(7, item.isReserved());
            preparedStatement.executeUpdate();

        } catch (Exception ignore) {

        }
    }
}
