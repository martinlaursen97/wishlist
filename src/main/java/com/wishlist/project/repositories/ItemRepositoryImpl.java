package com.wishlist.project.repositories;

import com.wishlist.project.domain.models.Item;
import com.wishlist.project.domain.models.User;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemRepositoryImpl implements ItemRepository {

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

    @Override
    public List<Item> getReservedItemsById(long id) {
        List<Item> items = new ArrayList<>();
        try {
            String query = "SELECT i.item_id, i.name, i.wishlist_id, i.image_url, i.price, i.location, i.notes, i.reserved, i.creation_date" +
                    " FROM sql11449169.item i JOIN sql11449169.wishlist w ON w.wishlist_id = i.wishlist_id WHERE user_id = " + id + " AND " +
                    "i.reserved = true";

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
    public Item getItemById(long id) {
        Item item = new Item();
        try {
            String query = "SELECT * FROM sql11449169.item WHERE item_id = " + id;

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();


            item.setId(resultSet.getLong("item_id"));
            item.setName(resultSet.getString("name"));
            item.setWishListId(resultSet.getLong("wishlist_id"));
            item.setImageUrl(resultSet.getString("image_url"));
            item.setPrice(resultSet.getDouble("price"));
            item.setLocation(resultSet.getString("location"));
            item.setNotes(resultSet.getString("notes"));
            item.setReserved(resultSet.getBoolean("reserved"));
            item.setDate(resultSet.getString("creation_date"));


        } catch (SQLException ignore) {

        }
        return item;
    }

    @Override
    public User getUserByItemId(long id) {
        User user = new User();
        try {
            String query = "SELECT * FROM sql11449169.user u WHERE u.user_id = (SELECT user_id FROM sql11449169.wishlist w " +
                    "JOIN sql11449169.item i ON w.wishlist_id = i.wishlist_id WHERE i.item_id = 1);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            user.setId(resultSet.getLong(1));
            user.setUsername(resultSet.getString(2));
            user.setPassword(resultSet.getString(3));
            user.setEmail(resultSet.getString(4));
            user.setPhone(resultSet.getString(5));
            user.setStreet(resultSet.getString(6));
            user.setCity(resultSet.getString(7));
            user.setZip(resultSet.getString(8));
            user.setDate(resultSet.getString(9));
        } catch (SQLException ignore) {

        }

        return user;
    }

    @Override
    public void unreserveItemById(long id) {
        try {
            String query = "UPDATE sql11449169.item SET reserved = false WHERE item_id = " + id;
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
        } catch (Exception ignore) {

        }
    }
}
