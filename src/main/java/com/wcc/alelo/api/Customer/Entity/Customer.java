package com.wcc.alelo.api.Customer.Entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column
    @NotNull
    @NotBlank
    @NotEmpty
    private String name;

    @Column
    @NotNull
    private Integer cityId;

    public Customer(){}

    public Customer(Integer id, @NotNull @NotBlank @NotEmpty String name,@NotNull Integer cityId) {
        this.id = id;
        this.name = name;
        this.cityId = cityId;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setCity(Integer cityId){
        this.cityId = cityId;
    }

    public Integer getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public Integer getCity(){
        return this.cityId;
    }
}
