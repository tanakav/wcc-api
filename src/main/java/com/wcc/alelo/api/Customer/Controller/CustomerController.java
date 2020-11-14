package com.wcc.alelo.api.Customer.Controller;

import com.wcc.alelo.api.Customer.Entity.Customer;
import com.wcc.alelo.api.Customer.Service.CustomerService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @ApiOperation(value= "Retorna lista de clientes")
    @ApiResponses(value={
            @ApiResponse(code =200, message = "Lista de clientes retornado com sucesso")
    })
    @GetMapping
    public ResponseEntity<List<Customer>> findAll(){
        return ResponseEntity.ok(customerService.findAll());
    }

    @ApiOperation(value="Retorna o cliente buscando por id")
    @ApiResponses(value={
            @ApiResponse(code=200,message="Cliente retornado com sucesso")
    })
    @GetMapping("/{userId}")
    public ResponseEntity<Customer> findById(@PathVariable Integer userId){
        Customer customer = customerService.findById(userId).orElse(null);

        if(customer == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(customer);
    }

    @ApiOperation(value="Salva um novo cliente no banco")
    @ApiResponses(value={
            @ApiResponse(code=201,message="Cliente salvo com sucesso")
    })
    @PostMapping
    public ResponseEntity<Customer> save(@RequestBody Customer customer){
        return ResponseEntity.status(201).body(customerService.save(customer));
    }

    @ApiOperation(value="Atualiza os dados de um cliente já cadastrado")
    @ApiResponses(value={
            @ApiResponse(code=200,message="Cliente atualizado com sucesso")
    })
    @PutMapping("/{userId}")
    public ResponseEntity<Customer> update(@PathVariable Integer userId,@RequestBody Customer customerEdit){
        Customer customer = customerService.findById(userId).orElse(null);

        if(customer == null){
            return ResponseEntity.notFound().build();
        }
        if(customerEdit.getName().isEmpty()){
            customer.setState(customerEdit.getState());
        }

        if(customerEdit.getState() != null){
            customer.setState(customerEdit.getState());
        }
        return ResponseEntity.status(200).body(customerService.save(customer));
    }

    @ApiOperation(value="Exclui cliente buscado por id")
    @ApiResponses(value={
            @ApiResponse(code=200,message="Cliente excluido com sucesso")
    })
    @DeleteMapping("/{userId}")
    public ResponseEntity<String> delete(@PathVariable Integer userId){
        customerService.deleteById(userId);
        return ResponseEntity.ok("Cliente excluído com sucesso");
    } 
}
