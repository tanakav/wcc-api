package com.wcc.alelo.api.State.Respository;

import com.wcc.alelo.api.State.Entity.State;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StateRepository extends CrudRepository<State, Integer> {
    List<State> findAll();
}
