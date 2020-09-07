package com.hasi.data.mongo.dal;

import com.hasi.data.mongo.document.User;

import java.util.List;
import java.util.Map;

public interface UserDal {
    List<User> getAllUsers();

    User getUserById(String userId);

    User addNewUser(User user);

    Object getAllAdditionalProperties(String userId);

    String addAdditionalProperties(String userId, Map<String, Object> properties);

    User updateUser(User user);

    void deleteUser(String userId);
}
