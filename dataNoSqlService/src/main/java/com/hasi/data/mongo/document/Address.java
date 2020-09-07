package com.hasi.data.mongo.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Serializable {
    private String addressId;
    private String houseNumber;
    private String streetName;
    private String zipCode;
    private String stateOrProvince;
    private String country;
}
