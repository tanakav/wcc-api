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
    public ResponseEntity<List<Customer>> findAll(){
        return ResponseEntity.ok(customerService.findAll());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Customer> findById(@PathVariable Integer userId){
        Customer customer = customerService.findById(userId).orElse(null);

        if(customer == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(customer);
    }

    @PostMapping
    public ResponseEntity<Customer> save(@RequestBody Customer customer){
        return ResponseEntity.status(201).body(customerService.save(customer));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Customer> update(@PathVariable Integer userId,@RequestBody Customer customerEdit){
        Customer customer = customerService.findById(userId).orElse(null);

        if(customer == null){
            return ResponseEntity.notFound().build();
        }

        customer.setCity(customerEdit.getCity());
        customer.setState(customerEdit.getState());
        customer.setName(customerEdit.getName());
        return ResponseEntity.status(200).body(customerService.save(customer));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> delete(@PathVariable Integer userId){
        customerService.deleteById(userId);
        return ResponseEntity.ok("Cliente excluído com sucesso");
    } 
}
