package com.leyton.services;

import com.leyton.ExceptionCustom;
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
     * @throws FileNotFoundException ExceptionCustom
     */
    public Set<Client> importClient(String path) throws FileNotFoundException {
        Scanner read = null;
        Set<Client> clients = new HashSet<>();

        try{
            read = new Scanner(new File(path));
            read.useDelimiter("-");

            while (read.hasNext()) {
                Client client = new Client();

                // Read the client last name
                client.setLastName(read.next());
                // Read the client first name
                client.setFirstName(read.next());
                // Read the client seniority
                //client.setSeniority(read.nextInt());

                String s = read.next();System.out.println(s);
                if (s.equals(" ") || s.equals("   ")) {
                    throw new ExceptionCustom("You cannot have a space and tabs instead of an int. Please enter the appropriate field.");

                }
                else {
                    // Read the client seniority
                    client.setSeniority(Integer.parseInt(s));
                }

                // calculate the discount from the seniority
                client.setDiscount(DiscountUtils.calculateDiscount(client.getSeniority()));

                // Add the client to the list
                clients.add(client);

            }
        } catch (ExceptionCustom e) {
            System.out.println(e.getMessage());
        }
        read.close();

        return clients;
    }
}
