package com.leyton;

import com.leyton.models.Client;
import com.leyton.services.ClientService;

import java.io.IOException;
import java.util.Set;


public class Main {
    public static void main (String [] args) throws IOException, MandatoryFieldException {

        ClientService service = new ClientService();
        Set<Client> clients =
                 service.importClient("/home/rimnez/ImportFileAPI/src/main/resources/clients.txt");

       //foreach using method reference
        clients.forEach(System.out::println);
    }

}
