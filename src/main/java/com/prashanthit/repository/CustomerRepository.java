package com.prashanthit.repository;

import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;

import com.prashanthit.entity.CustomerEntity;

@Registered
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {

}
