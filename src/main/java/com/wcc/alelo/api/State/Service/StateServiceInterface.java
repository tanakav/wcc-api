package com.wcc.alelo.api.State.Service;

import com.wcc.alelo.api.State.Entity.State;

import java.util.List;

public interface StateServiceInterface {
    List<State> findAll();
    State findById(Integer id);

}
