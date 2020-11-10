package com.wcc.alelo.api.Client.Entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column
    @NotNull
    @NotBlank
    @NotEmpty
    private String name;

    @Column
    private String city;

    @Column
    @Size(max = 2)
    private String state;

    @Column
    @CreatedDate
    private LocalDateTime createdAt;

    public void setName(String name){
        this.name = name;
    }

    public void setCity(String City){
        this.city = city;
    }

    public void setState(String state){
        this.state = state;
    }

    public String getName(){
        return this.name;
    }

    public String getCity(){
        return this.city;
    }

    public String getState(){
        return this.state;
    }
}
