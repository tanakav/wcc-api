package com.wcc.alelo.api.State.Service;

import com.wcc.alelo.api.State.Entity.State;
import com.wcc.alelo.api.State.Respository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService implements StateServiceInterface {
    @Autowired
    StateRepository stateRepository;

    @Override
    public List<State> findAll() {
        return stateRepository.findAll();
    }

    @Override
    public State findById(Integer id) {
        if(!stateRepository.existsById(id)) return null;
        return stateRepository.findById(id).get();
    }

    public State save(State state){
        return stateRepository.save(state);
    }
}
