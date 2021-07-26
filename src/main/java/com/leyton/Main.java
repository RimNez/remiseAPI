package com.leyton;

import com.leyton.exceptions.MandatoryFieldException;
import com.leyton.models.Client;
import com.leyton.services.ClientService;

import java.io.IOException;
import java.util.Set;



public class Main {
    public static void main (String [] args) throws IOException {

        ClientService service = new ClientService();
        Set<Client> clients =
                service.importClient("/home/rimnez/ImportFileAPI/src/main/resources/exemple.txt");

        //foreach using method reference
        clients.forEach(System.out::println);
        service.createNewFile(service.importClient("/home/rimnez/ImportFileAPI/src/main/resources/exemple.txt"),"/home/rimnez/ImportFileAPI/src/main/resources/outputFile.txt" );
    }

}


