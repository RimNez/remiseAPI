package com.leyton.services;

import com.leyton.models.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;


public interface ClientService {
     static final Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);

    /**
     * Service that returns a list of clients from a file and calculate discount
     * @param path file path
     * @return list of clients
     * @throws FileNotFoundException NumberFormatException MandatoryFieldException FieldFormatException
     */
     public Set<Client> importClient(final String path) throws IOException;


    /**
     * Service that take a list of clients and create a file into the specified path
     * @param clients list of clients
     * @param path file path
     * @throws IOException
     */
     public void createNewFile(Set<Client> clients, final String path) throws IOException;

     /**
     * Service that read a file line by line and calculate discount
     * @param path file path
     * @param clients list of clients
     * @throws FileNotFoundException IOException MandatoryFieldException FieldFormatException
     */
     public void readAndModifyFile(final String path, Set<Client> clients) throws IOException;

}
