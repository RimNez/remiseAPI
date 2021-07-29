package com.leyton.controllers;

import com.leyton.models.Client;
import com.leyton.services.ClientService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
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
        //Save the result list of clients on the database
        for(Client client : clientService.importClient(temp_file.getPath())) {
            clientService.save(client);
        }

        return clientService.importClient(temp_file.getPath());
    }

    @GetMapping("/{lastName}")
    public Client findByLastName(@PathVariable final String lastName) {
        return clientService.findByLastName(lastName);
    }

}
