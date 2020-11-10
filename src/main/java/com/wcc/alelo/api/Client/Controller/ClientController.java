package com.wcc.alelo.api.Client.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClientController {

    @GetMapping
    public String getHello(){
        return "testando essa budega de novo";
    }
}
