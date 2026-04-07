package com.prashanthit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Customer_DTLS_TBL")
public class Customer {

    @Id
    @GeneratedValue
    private Integer customerId;
    private String customerName;
    private String customerEmail;
    private Long phoneNumber;
    private String customerAddress;
}
