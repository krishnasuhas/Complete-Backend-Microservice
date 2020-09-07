package com.hasi.data.mongo.dal.impl;

import com.hasi.data.mongo.dal.AddressDal;
import com.hasi.data.mongo.document.Address;
import com.hasi.data.mongo.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddressDALImpl implements AddressDal {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Address> getAllAddresses(String userId) {
        return addressRepository.findAll();
    }

    @Override
    public Address addNewAddress(String userId, Address address) {
        return null;
    }

    @Override
    public Address updateAddress(String userId, Address address) {
        return null;
    }

    @Override
    public Address deleteAddress(String userId, String addressId) {
        return null;
    }
}
