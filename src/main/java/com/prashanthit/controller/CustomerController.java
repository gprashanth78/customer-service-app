package com.prashanthit.controller;

import com.prashanthit.entity.CustomerEntity;
import com.prashanthit.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/customer", produces = "application/json")
    public ResponseEntity<List<CustomerEntity>> getAllCustomers() {
        List<CustomerEntity> customerEntityList = customerService.getAllCustomerDetails();
        if (customerEntityList != null && !customerEntityList.isEmpty()){
            return new ResponseEntity<>(customerEntityList, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(value = "/customer", consumes = "application/json")
    public ResponseEntity<String> addCustomer(@RequestBody CustomerEntity customerEntity) {
        CustomerEntity customer = customerService.addCustomerDetails(customerEntity);
        if(customer != null){
            return new ResponseEntity<>("Customer record created", HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>("Failed to create customer Record", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/customer/{customerId}", produces = "application/json")
    public ResponseEntity<CustomerEntity> getCustomerById(@PathVariable Integer customerId) {
        CustomerEntity customer = customerService.getCustomerById(customerId);
        if (customer != null){
            return new ResponseEntity<>(customer,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value="/customer/{customerId}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable Integer customerId) {
       boolean deleteCustomer = customerService.deleteCustomerById(customerId);
       if (deleteCustomer){
           return new ResponseEntity<>("Customer record deleted", HttpStatus.OK);
       }else {
           return new ResponseEntity<>("Failed to delete customer", HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }
}
