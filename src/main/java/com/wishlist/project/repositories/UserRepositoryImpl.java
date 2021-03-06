package com.wishlist.project.repositories;

import com.wishlist.project.domain.models.User;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final Connection connection = DBManager.getConnection();

    @Override
    public void createUser(User user) {
        try {
            String query = "insert into heroku_9fe615c2f166282.user(username, password, email, phone, street, city, zip, creation_date) values (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement;

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.setString(5, user.getStreet());
            preparedStatement.setString(6, user.getCity());
            preparedStatement.setString(7, user.getZip());
            preparedStatement.setString(8, user.getDate());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean loginValid(String username, String password) {
        boolean valid = false;
        try {
            String query = "SELECT * FROM heroku_9fe615c2f166282.user WHERE username = '" + username + "' AND password = " + password;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                valid = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return valid;
    }

    @Override
    public boolean usernameTaken(String username) {
        boolean valid = false;
        try {
            String query = "SELECT * FROM heroku_9fe615c2f166282.user WHERE username = '" + username + "'";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                valid = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return valid;
    }

    @Override
    public User findByUsername(String username) {
        User user = new User();
        try {
            String query = "SELECT * FROM heroku_9fe615c2f166282.user WHERE username = '" + username + "'";
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public String getNameById(long userId) {
        String name = null;
        try {
            String query = "SELECT username FROM heroku_9fe615c2f166282.user WHERE user_id = " + userId;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            name = resultSet.getString("username");

        } catch (SQLException ignore) {

        }
        return name;
    }

    @Override
    public User getUserByItemId(long id) {
        User user = new User();
        try {
            String query = "SELECT * FROM heroku_9fe615c2f166282.user u WHERE u.user_id = (SELECT user_id FROM heroku_9fe615c2f166282.wishlist w " +
                    "JOIN heroku_9fe615c2f166282.item i ON w.wishlist_id = i.wishlist_id WHERE i.item_id = 1);";
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}

