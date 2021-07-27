package com.leyton.services;

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
        String path = "C:\\Users\\nezha\\IdeaProjects\\remiseAPI\\src\\test\\resources\\clients.txt";
        //WHEN
        Set<Client> clients = clientService.importClient(path);
        //THEN
        Assert.assertEquals(5, clients.size());
        Assert.assertEquals("NEZHARI", clients.stream().findFirst().get().getLastName());
    }
}
