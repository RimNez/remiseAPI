package com.leyton.controllers;

import com.leyton.models.Client;
import com.leyton.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.Set;

@Controller
public class ClientController {


       // private final ClientService clientService;

       /* @Autowired
        public ClientController(ClientService clientService) {
            this.clientService = clientService;
        }*/


        @RequestMapping("/")
        public String importFile (Model model) {

            return "view";
        }



    }
