package com.leyton.controllers;

import com.leyton.models.Client;
import com.leyton.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Set;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/import")
    public Set<Client> importFile () throws IOException {
        return clientService.importClient("C:\\Users\\nezha\\IdeaProjects\\remiseAPI\\src\\main\\resources\\exemple.txt");
    }

    @PostMapping("/import")
    public Set<Client> importFilePost(@RequestBody String path) throws IOException {
        return clientService.importClient(path);
    }

    @PostMapping("/import/param")
    public Set<Client> importFilePostParam(@RequestParam("path") String path) throws IOException {
        return clientService.importClient(path);
    }

}
