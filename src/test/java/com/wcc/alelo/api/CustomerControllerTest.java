package com.wcc.alelo.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wcc.alelo.api.Customer.Controller.CustomerController;
import com.wcc.alelo.api.Customer.Entity.Customer;
import com.wcc.alelo.api.Customer.Service.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = CustomerController.class)
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerServiceMock;

    private List<Customer> customerList;

    @BeforeEach
    void config(){
        this.customerList = new ArrayList<>();
        this.customerList.add(new Customer(1,"Test1",1));
        this.customerList.add(new Customer(2,"Test2",2));
        this.customerList.add(new Customer(3,"Test3",3));
        this.customerList.add(new Customer(4,"Test4",4));
        this.customerList.add(new Customer(5,"Test5",5));
    }

    @Test
    void shouldFindAllCustomers() throws Exception {
        when(customerServiceMock.findAll()).thenReturn(customerList);

        MvcResult result = this.mockMvc.perform(get("/clientes"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(result.getResponse().getContentAsString(),new ObjectMapper().writeValueAsString(customerList));
    }

    @Test
    void shouldFindCustomerById() throws Exception {
        Integer id = customerList.get(1).getId();
        when(customerServiceMock.findById(id)).thenReturn(Optional.of(customerList.get(1)));

        MvcResult result = this.mockMvc.perform(get("/clientes/{id}",id))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(result.getResponse().getContentAsString(), new ObjectMapper().writeValueAsString(customerList.get(1)));
    }

    @Test
    void shouldOldObjectWithSomeFieldUpdatedWhenRequestBodyIsIncomplete() throws Exception {
        String newName = "Nome Editado";
        Integer id = customerList.get(1).getId();
        Customer updatedCustomer = customerList.get(1);
        updatedCustomer.setName(newName);


        when(customerServiceMock.save(customerList.get(1))).thenReturn(updatedCustomer);

        MvcResult result = this.mockMvc
                .perform(put("/clientes/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\""+newName+"\"}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(result.getResponse().getContentAsString(),new ObjectMapper().writeValueAsString(updatedCustomer));
    }
}