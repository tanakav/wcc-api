package com.wcc.alelo.api.Customer.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.wcc.alelo.api.Customer.Entity.Customer;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Integer> {
    List<Customer> findAll();
    List<Customer> findByStateId(Integer id);
    List<Customer> findByCityId(Integer id);

}
