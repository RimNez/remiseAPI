package com.leyton;

import com.leyton.models.Client;
import com.leyton.services.ClientService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class Main {
    public static void main (String [] args) throws IOException {

        ClientService service = new ClientService();
        Set<Client> clients =
                 service.importClient("/home/rimnez/ImportFileAPI/src/main/resources/clients.txt");

       //foreach using lambda expression
        clients.forEach(c -> System.out.println(c));
    }

}
