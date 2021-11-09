package com.wishlist.project.repositories;

import com.wishlist.project.domain.models.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    void createUser(User user);
    boolean loginValid(String username, String password);
    boolean usernameTaken(String username);
    User findByUsername(String username);
    String getNameById(long userId);
    User getUserByItemId(long id);
}
