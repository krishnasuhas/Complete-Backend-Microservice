package com.hasi.data.mongo.dal;

import com.hasi.data.mongo.document.Address;

import java.util.List;

public interface AddressDal {
    List<Address> getAllAddresses(String userId);

    Address addNewAddress(String userId, Address address);

    Address updateAddress(String userId, Address address);

    Address deleteAddress(String userId, String addressId);
}
