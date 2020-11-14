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
    public Customer findById(Integer id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if(!customer.isPresent()) return null;
        return customer.get();
    }

    @Override
    public List<Customer> findAllByStateId(Integer id) {
        return customerRepository.findByStateId(id);
    }

    @Override
    public Boolean delete(Integer userId) {
        Optional<Customer> customer = customerRepository.findById(userId);
        if(customer.isPresent()) {
            customerRepository.delete(customer.get());
            return true;
        }
        return false;
    }

    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer update(Integer userId, Customer customer){
        Optional<Customer> oldCustomer =customerRepository.findById(userId);

        if(!oldCustomer.isPresent()) return null;

        Customer updatedCustomer =  oldCustomer.get();
        updatedCustomer.setState(customer.getState());
        updatedCustomer.setName(customer.getName());
        customerRepository.save(updatedCustomer);
        return updatedCustomer;
    }

}
