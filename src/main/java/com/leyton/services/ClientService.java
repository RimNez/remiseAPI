package com.leyton.services;

import com.leyton.models.Client;
import com.leyton.utils.DiscountUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class ClientService {
   /**
     * Service that returns a list of clients from a file and calculate discount
     * @param path file path
     * @return list of clients
     * @throws FileNotFoundException
     */
    public Set<Client> importClient(String path) throws FileNotFoundException {
        Scanner read = new Scanner(new File(path));
        read.useDelimiter("-");
        Set<Client> clients = new HashSet<>();

        while (read.hasNext()) {
            Client client = new Client();
            // Read the client last name
            client.setLastName(read.next());
            // Read the client first name
            client.setFirstName(read.next());
            // Read the client seniority
            client.setSeniority(read.nextInt());

            // calculate the discount from the seniority
            client.setDiscount(DiscountUtils.calculateDiscount(client.getSeniority()));

            // Add the client to the list
            clients.add(client);
        }
        return clients;

    }
}
