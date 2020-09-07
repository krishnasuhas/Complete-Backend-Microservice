package com.hasi.data.mongo.repository;

import com.hasi.data.mongo.document.Address;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends MongoRepository<Address, String> {
}
