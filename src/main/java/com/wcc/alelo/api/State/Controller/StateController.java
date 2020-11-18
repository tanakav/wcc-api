package com.wcc.alelo.api.State.Controller;

import com.wcc.alelo.api.State.Entity.State;
import com.wcc.alelo.api.State.Service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estados")
public class StateController {
    @Autowired
    StateService stateService;

    @GetMapping
    public ResponseEntity<List<State>> findAll(){
        return ResponseEntity.ok(stateService.findAll());
    }

    @GetMapping("/{stateId}")
    public ResponseEntity<State> findById(@PathVariable Integer stateId){
        State state = stateService.findById(stateId);
        if(state == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(state);
    }

    @PostMapping
    public ResponseEntity<State> save(@RequestBody State state){
        return ResponseEntity.status(201).body(stateService.save(state));
    }
}
