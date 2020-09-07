package com.hasi.data.mongo.dal.impl;

import com.hasi.data.mongo.dal.UserDal;
import com.hasi.data.mongo.document.User;
import com.hasi.data.mongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class UserDALImpl implements UserDal {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public List<User> getAllUsers() {
        return mongoTemplate.findAll(User.class);
    }

    @Override
    public User getUserById(String userId) {
        Query query = new Query();
        query.addCriteria((Criteria.where("userId").is(userId)));
        return mongoTemplate.findOne(query, User.class);
    }

    @Override
    public User addNewUser(User user) {
        user.setCreationDate(new Date());
        return mongoTemplate.save(user);
    }

    @Override
    public Object getAllAdditionalProperties(String userId) {
        Query query = new Query();
        query.fields().include("additionalProperties");
        query.addCriteria(Criteria.where("userId").is(userId).andOperator(Criteria.where("additionalProperties").exists(true)));
        User user = mongoTemplate.findOne(query, User.class);
        return user != null ? user.getAdditionalProperties() : null;
    }

    @Override
    public String addAdditionalProperties(String userId, Map<String, Object> properties) {
        User user = getUserById(userId);
        if (user != null) {
            properties.forEach(user.getAdditionalProperties()::put);
            mongoTemplate.save(user);
            return "Added New Properties";
        } else {
            return "User not found!";
        }
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
