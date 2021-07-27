package com.leyton.controllers;

import com.leyton.models.Client;
import com.leyton.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.Set;

@RestController
public class ClientController {

    @Autowired
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/")
        public Set<Client> importFile () throws IOException {

        return clientService.importClient("/home/rimnez/ImportFileAPI/src/main/resources/exemple.txt");

    }

    }
