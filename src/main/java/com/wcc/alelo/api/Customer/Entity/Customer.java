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
    private Integer cityId;

    @Column
    private Integer stateId;

    public Customer(){}

    public void setName(String name){
        this.name = name;
    }

    public void setCity(Integer cityId){
        this.cityId = cityId;
    }

    public void setState(Integer stateId){
        this.stateId = stateId;
    }

    public String getName(){
        return this.name;
    }

    public Integer getCity(){
        return this.cityId;
    }

    public Integer getState(){
        return this.stateId;
    }
}
