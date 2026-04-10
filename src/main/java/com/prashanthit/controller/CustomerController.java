package com.prashanthit.controller;

import com.prashanthit.entity.CustomerEntity;
import com.prashanthit.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.prashanthit.constants.CustomerConstants.*;

@RestController
@RequestMapping(API_CUSTOMER_BASE)
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<CustomerEntity>> getAllCustomers() {
        List<CustomerEntity> customerEntityList = customerService.getAllCustomerDetails();
        if (customerEntityList != null && !customerEntityList.isEmpty()){
            return new ResponseEntity<>(customerEntityList, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<String> addCustomer(@Valid @RequestBody CustomerEntity customerEntity) {
        CustomerEntity customer = customerService.addCustomerDetails(customerEntity);
        if(customer != null){
            return new ResponseEntity<>(CUSTOMER_RECORD_CREATED, HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(FAILED_TO_CREATE_CUSTOMER_RECORD, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{customerId}", produces = "application/json")
    public ResponseEntity<CustomerEntity> getCustomerById(@Valid @PathVariable Integer customerId) {
        CustomerEntity customer = customerService.getCustomerById(customerId);
        if (customer != null){
            return new ResponseEntity<>(customer,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value="/{customerId}")
    public ResponseEntity<String> deleteCustomerById(@Valid @PathVariable Integer customerId) {
       boolean deleteCustomer = customerService.deleteCustomerById(customerId);
       if (deleteCustomer){
           return new ResponseEntity<>(CUSTOMER_RECORD_DELETED, HttpStatus.OK);
       }else {
           return new ResponseEntity<>(FAILED_TO_DELETE_CUSTOMER, HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }
}
