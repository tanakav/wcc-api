package com.wcc.alelo.api.Customer.Service;

import com.wcc.alelo.api.Customer.Entity.Customer;

import java.util.List;

public interface CustomerServiceInterface {

    List<Customer> findAll();
    Customer findById(Integer id);
    List<Customer> findAllByStateId(Integer id);
    Boolean delete(Integer id);
    Customer update(Integer id, Customer customer);

}
