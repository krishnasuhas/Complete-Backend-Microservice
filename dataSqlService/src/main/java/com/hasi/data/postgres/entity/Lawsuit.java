package com.hasi.data.postgres.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "LAWSUIT")
public class Lawsuit {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "LAWSUIT_ID")
    private String lawsuitId;

    @Column(name = "CLIENT_ID")
    private String clientId;

    @Column(name = "LAWYER_ID")
    private String lawyerId;

    @Column(name = "CREATION_DATE")
    private String creationDate;
}
