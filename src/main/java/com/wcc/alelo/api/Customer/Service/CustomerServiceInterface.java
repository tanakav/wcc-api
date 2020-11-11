package com.wcc.alelo.api.Customer.Service;

import com.wcc.alelo.api.Customer.Entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerServiceInterface {

    List<Customer> findAll();
    Optional<Customer> findById(Integer id);
    List<Customer> findAllByStateId(Integer id);
    List<Customer> findAllByCityId(Integer id);


}
