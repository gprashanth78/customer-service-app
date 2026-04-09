package com.prashanthit.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="Customer_DTLS_TBL")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    private String customerName;
    private String customerEmail;
    private Long phoneNumber;
    private String customerAddress;
}
