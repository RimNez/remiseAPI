package com.leyton.services;

import com.leyton.ClientService;
import com.leyton.models.Client;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientServiceTest {
    @Autowired
    private ClientService clientService;

    @Test
    public void importClientTest() throws IOException {
        //GIVEN
        String path = "/home/rimnez/ImportFileAPI/src/main/resources/exemple.txt";
        //WHEN
        Set<Client> clients = clientService.importClient(path);
        //THEN : The number of clients should be :
        Assert.assertEquals(294, clients.size());
        Assert.assertEquals("Benjie", clients.stream().filter(c->c.getSeniority()==(7)).findFirst().get().getLastName());
    }
}
