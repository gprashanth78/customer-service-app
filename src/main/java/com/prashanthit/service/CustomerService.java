package com.prashanthit.service;

import com.prashanthit.entity.CustomerEntity;

import java.util.List;

public interface CustomerService {

    public CustomerEntity addCustomerDetails(CustomerEntity customer);

    public List<CustomerEntity> getAllCustomerDetails();

    public CustomerEntity getCustomerById(Integer customerId);

    public boolean deleteCustomerById(Integer customerId);
}
