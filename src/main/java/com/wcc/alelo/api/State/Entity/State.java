package com.wcc.alelo.api.State.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class State {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Integer id;

    @Column(unique = true)
    @Size(max=2)
    @NotNull
    private String abbreviation;

    public State(@NotNull @NotBlank @Size(max = 2) String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public State() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreaviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
