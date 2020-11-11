package com.wcc.alelo.api.Customer.Controller;

import com.wcc.alelo.api.Customer.Entity.Customer;
import com.wcc.alelo.api.Customer.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> findAll(){
        return customerService.findAll();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Customer> findById(@PathVariable Integer userId){
        Customer customer = customerService.findById(userId).orElse(null);

        if(customer == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(customer);
    }

    @PostMapping
    public Customer save(Customer customer){
        return customerService.save(customer);
    }
}