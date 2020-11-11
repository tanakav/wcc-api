package com.wcc.alelo.api.Customer.Service;

import com.wcc.alelo.api.Customer.Entity.Customer;
import com.wcc.alelo.api.Customer.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements CustomerServiceInterface {

    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> findAll(){
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Integer id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> findAllByStateId(Integer id) {
        return customerRepository.findByStateId(id);
    }

    @Override
    public List<Customer> findAllByCityId(Integer id) {
        return customerRepository.findByCityId(id);
    }

    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }
}
