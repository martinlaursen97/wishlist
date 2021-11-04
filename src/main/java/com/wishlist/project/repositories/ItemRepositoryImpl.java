package com.wishlist.project.repositories;

import com.wishlist.project.domain.models.Item;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Item> getItems(long id) {
        List<Item> items = new ArrayList<>();
        try {
            String query = "SELECT * FROM sql11448324.item WHERE wishlist_id = " + id + " ORDER BY item_id DESC";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                Item item = new Item();
                item.setId(resultSet.getLong("item_id"));
                item.setName(resultSet.getString("name"));
                item.setWishListId(resultSet.getLong("wishlist_id"));
                item.setName(resultSet.getString("image_url"));
                item.setNotes(resultSet.getString("price"));
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
    public void clearItemsById(long id) {
        try {
            String query = "DELETE FROM sql11448324.item WHERE user_id = " + id;
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
        } catch (Exception ignore) {

        }
    }

    @Override
    public Item findItemsById(long id) {
        Item item = new Item();

        try {
            String query = "SELECT * FROM sql11448324.item WHERE wishlist_id = " + id;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            item.setId(resultSet.getLong("item_id"));
            item.setName(resultSet.getString("name"));
            item.setWishListId(resultSet.getLong("wishlist_id"));
            item.setName(resultSet.getString("image_url"));
            item.setNotes(resultSet.getString("price"));
            item.setLocation(resultSet.getString("location"));
            item.setNotes(resultSet.getString("notes"));
            item.setReserved(resultSet.getBoolean("reserved"));
            item.setDate(resultSet.getString("creation_date"));
        } catch (SQLException ignore) {

        }
        return item;
    }
}
