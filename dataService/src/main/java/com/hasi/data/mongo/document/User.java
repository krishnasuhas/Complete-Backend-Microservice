package com.hasi.data.mongo.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.*;

@Data
@Builder
@Document
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    @Id
    private String userId;
    private String firstName;
    private String middleName;
    private String lastName;
    private Date dateOfBirth;
    private Date creationDate;
    private Date lastModificationDate;
    private List<String> phoneNumbers = new ArrayList<>();
    private Map<AddressType, Address> addresses = new HashMap<>();
    private Map<String, Object> additionalProperties = new HashMap<>();
}

