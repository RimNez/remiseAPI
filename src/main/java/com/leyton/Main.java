package com.leyton;

import com.leyton.exceptions.ExceptionCustom;
import com.leyton.models.Client;
import com.leyton.services.ClientService;

import java.io.IOException;
import java.util.Set;


public class Main {
    public static void main (String [] args) throws IOException {

        ClientService service = new ClientService();
        Set<Client> clients =
                 service.importClient("C:\\Users\\nezha\\IdeaProjects\\remiseAPI\\remiseAPI\\src\\main\\resources\\exemple.txt");

       //foreach using method reference
        clients.forEach(System.out::println);
        service.fileOut(service.importClient("C:\\Users\\nezha\\IdeaProjects\\remiseAPI\\remiseAPI\\src\\main\\resources\\exemple.txt"),"C:\\Users\\nezha\\IdeaProjects\\remiseAPI\\remiseAPI\\src\\main\\resources\\outputFile.txt" );
    }

}
