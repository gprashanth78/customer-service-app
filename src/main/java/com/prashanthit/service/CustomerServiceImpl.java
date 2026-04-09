package com.prashanthit.service;

import com.prashanthit.entity.CustomerEntity;
import com.prashanthit.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerEntity addCustomerDetails(CustomerEntity customer) {
        CustomerEntity customerEntity = customerRepository.save(customer);
        return customerEntity;
    }

    @Override
    public List<CustomerEntity> getAllCustomerDetails() {
        return customerRepository.findAll();
    }

    @Override
    public CustomerEntity getCustomerById(Integer customerId) {
        Optional<CustomerEntity> getCustomer = customerRepository.findById(customerId);
        if(getCustomer.isPresent()){
            return getCustomer.get();
        }
        return null;
    }

    @Override
    public boolean deleteCustomerById(Integer customerId) {
        customerRepository.deleteById(customerId);
        return true;
    }
}
