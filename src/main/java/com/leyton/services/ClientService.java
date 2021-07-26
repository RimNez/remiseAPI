package com.leyton.services;

import com.leyton.exceptions.FieldFormatException;
import com.leyton.exceptions.MandatoryFieldException;
import com.leyton.models.Client;
import com.leyton.utils.DiscountUtils;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class ClientService {

    private static final Logger logger = LoggerFactory.getLogger(ClientService.class);

    /**
     * Service that returns a list of clients from a file and calculate discount
     * @param path file path
     * @return list of clients
     * @throws FileNotFoundException NumberFormatException MandatoryFieldException FieldFormatException
     */
    public Set<Client> importClient(final String path) throws IOException {
        Set<Client> clients = new HashSet<>();
        //Get the extension of the file using FilenameUtils.getExtension() from the library commons.io
        String extension = FilenameUtils.getExtension(path);
        if (! (extension.equals("txt"))) {
            logger.error(" Please Enter the appropriate path file (.txt)");
        }
        else {
            readAndModifyFile(path,clients);
        }
        return clients;
    }

    /**
     * Service that take a list of clients and create a file into the specified path
     * @param clients list of clients
     * @param path file path
     * @throws IOException
     */
    public void createNewFile(Set<Client> clients, final String path) throws IOException {

        //Using FileWriter class to write characters into a file that exists or doesn't exist in the specified path.
        FileWriter fw = new FileWriter(path);

        //Write line by line into the file. Each line is client's properties.
        for(Client client: clients) {
            fw.write(client.toString()+System.lineSeparator());
        }
        fw.close();
    }

    /**
     * Service that read a file line by line and calculate discount
     * @param path file path
     * @param clients list of clients
     * @throws FileNotFoundException IOException MandatoryFieldException FieldFormatException
     */
    public void readAndModifyFile(final String path, Set<Client> clients) throws IOException  {

            String line;
            InputStream input = new FileInputStream(path);
            InputStreamReader reader = new InputStreamReader(input,
                    StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(reader);

            while((line = br.readLine()) != null) {//while the file contains lines continue
                String[] array = line.split("-");
                Client client = new Client();
                // Read the client last name
                client.setLastName(array[0]);
                // Read the client first name
                client.setFirstName(array[1]);
                try {
                    String seniority = array[2].trim(); //eliminating leading and trailing spaces
                    if (seniority.isEmpty()) { //Customized Exception for empty fields
                        logger.warn("Mandatory Field Exception");
                        logger.info("Name of the client with the exception : {}", client.getLastName());
                        throw new MandatoryFieldException("####You cannot have an empty field. Please enter the appropriate field.");
                    } else { //else Parsing the String into an Integer and putting it in the object client
                        try {
                            client.setSeniority(Integer.parseInt(seniority));// Read the client seniority
                        } catch (NumberFormatException e) {//Exceptions for inappropriate fields
                            logger.error("Invalid integer : Field Format Exception");
                            logger.info("Name of the client with the exception : {}", client.getLastName());
                            throw new FieldFormatException("####You cannot have a string instead of an int. Please enter the appropriate field.");
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
    }
}