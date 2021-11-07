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
            String query = "insert into sql11449169.item(name, wishlist_id, image_url, price, location, notes, reserved, creation_date) values (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement;

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, item.getName());
            preparedStatement.setLong(2, item.getWishListId());
            preparedStatement.setString(3, item.getImageUrl());
            preparedStatement.setDouble(4, item.getPrice());
            preparedStatement.setString(5, item.getLocation());
            preparedStatement.setString(6, item.getNotes());
            preparedStatement.setBoolean(7, item.isReserved());
            preparedStatement.setString(8, item.getDate());
            preparedStatement.executeUpdate();

        } catch (Exception ignore) {

        }
    }

    @Override
    public void reserveItemById(long id) {
        try {
            String query = "UPDATE sql11449169.item SET reserved = true WHERE item_id = " + id;
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
        } catch (Exception ignore) {

        }
    }
}
