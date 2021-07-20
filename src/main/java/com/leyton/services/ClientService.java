package com.leyton.services;

import com.leyton.FieldFormatException;
import com.leyton.MandatoryFieldException;
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
     * @throws FileNotFoundException NumberFormatException MandatoryFieldException FieldFormatException
     */
    public Set<Client> importClient(String path) throws FileNotFoundException {
        Scanner read = null;
        Set<Client> clients = new HashSet<>();
        read = new Scanner(new File(path));
        read.useDelimiter("-");

        try {
            while (read.hasNext()) {
                Client client = new Client();
                // Read the client last name
                client.setLastName(read.next());
                // Read the client first name
                client.setFirstName(read.next());
                try {
                    String s = read.next().trim(); //eliminating leading and trailing spaces
                    if (s.isEmpty()) { //Customized Exception for empty fields
                        throw new MandatoryFieldException("You cannot have an empty field. Please enter the appropriate field.");
                    } else { //else Parsing the String into an Integer and putting it in the object client
                        try {
                            client.setSeniority(Integer.parseInt(s));// Read the client seniority

                        } catch (NumberFormatException e) {//Exceptions for inappropriate fields
                            System.out.println("Invalid integer");
                            throw new FieldFormatException("You cannot have a string instead of an int. Please enter the appropriate field.");

                        }
                        // calculate the discount from the seniority
                        client.setDiscount(DiscountUtils.calculateDiscount(client.getSeniority()));

                        // Add the client to the list
                        clients.add(client);
                    }
                } catch (MandatoryFieldException | FieldFormatException e) {
                    System.out.println(e.getMessage());
                }

            }
        }catch (NoSuchElementException exception) {
            System.out.println("Invalid line");//Exception that a line is empty
        }

        read.close();

        return clients;
    }
}
