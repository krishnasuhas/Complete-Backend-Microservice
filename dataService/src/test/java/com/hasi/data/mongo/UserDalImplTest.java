package com.hasi.data.mongo;

import com.hasi.data.mongo.config.MongoConfiguration;
import com.hasi.data.mongo.dal.impl.UserDALImpl;
import com.hasi.data.mongo.document.Address;
import com.hasi.data.mongo.document.AddressType;
import com.hasi.data.mongo.document.User;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MongoConfiguration.class)
public class UserDalImplTest {
    private static User user;

    @Autowired
    UserDALImpl userDALImpl;

    private static User createUser() {
        return User.builder()
                .firstName("Suhas")
                .lastName("Jaladi")
                .lastModificationDate(new Date())
                .phoneNumbers(Collections.singletonList("1"))
                .addresses(createAddressMap())
                .additionalProperties(new HashMap<>())
                .build();
    }

    private static Map<AddressType, Address> createAddressMap() {
        Map<AddressType, Address> map = new HashMap<>();
        map.put(AddressType.HOME, createAddress());
        return map;
    }

    private static Address createAddress() {
        return Address.builder()
                .houseNumber("h1")
                .streetName("s1")
                .stateOrProvince("sp1")
                .zipCode("1")
                .build();
    }

    @BeforeClass
    public static void init() {
        user = createUser();
    }

    @Test
    public void testUserPersistence() {
        userDALImpl.addNewUser(user);
        User retrievedUser = userDALImpl.getUserById(user.getUserId());
        Assert.assertEquals(retrievedUser.toString(), user.toString());
        userDALImpl.deleteUser(retrievedUser.getUserId());
        retrievedUser = userDALImpl.getUserById(retrievedUser.getUserId());
        Assert.assertNull(retrievedUser);
    }
}
