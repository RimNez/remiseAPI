package com.leyton.controllers;

import com.leyton.models.Client;
import com.leyton.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

@RestController
@RequestMapping("/client")
public class ClientController {


    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/import")
    public Set<Client> importFile () throws IOException {
        return clientService.importClient("/home/rimnez/ImportFileAPI/src/main/resources/exemple.txt");
    }

    @PostMapping("/import")
    public Set<Client> importFilePost(@RequestBody String path) throws IOException {
        return clientService.importClient(path);
    }

    @PostMapping("/import/param")
    public Set<Client> importFilePostParam(@RequestParam("path") String path) throws IOException {
        return clientService.importClient(path);
    }
    @PostMapping("/uploads")
    public Set<Client> upload(@RequestParam("file") MultipartFile file) throws IOException {
        //Get the name of the multipartFile
        String fileName = file.getOriginalFilename();
        //Save the file locally
        File temp_file = new File("/home/rimnez/ImportFileAPI/src/main/resources/"+fileName);
        file.transferTo(temp_file);
        return clientService.importClient(temp_file.getPath());
    }
}
