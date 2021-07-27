package com.leyton;

import com.leyton.controllers.ClientController;
import com.leyton.models.Client;
import com.leyton.services.ClientService;
import com.leyton.services.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import com.leyton.controllers.ClientController;
import java.io.File;
import java.io.IOException;
import java.util.Set;


@SpringBootApplication
//@ComponentScan{"com.leyton","com.leyton.controller"})
public class SpringBootApiApplication {

    @Autowired
    private ClientService service;
    public static void main(String[] args) {

        SpringApplication.run(SpringBootApiApplication.class, args);
    }



}


