
package com.gorbunov.services.impl;

import com.gorbunov.dao.ClientDao;
import com.gorbunov.dao.impl.ClientDaoImpl;
import com.gorbunov.domain.Client;
import com.gorbunov.services.ClientService;
import com.gorbunov.validator.BusinessException;
import com.gorbunov.validator.ValidationService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class ClientServiceImplTest {

    private ClientDao clientDao = Mockito.mock(ClientDaoImpl.class);
    private ValidationService validationService = Mockito.mock(ValidationService.class);
    private ClientService clientService;

    @Before
    public void init() {
        clientService = new ClientServiceImpl(clientDao, validationService);
    }

    @Test
    public void createClientWithFullParametersTest() throws BusinessException {
        //GIVEN
        long id = 1;
        String name = "Test";
        String surname = "Test";
        int age = 21;
        String phone = "+380936548547";
        String email = "test@gmail.com";

        //WHEN
        Client expectedClient = new Client(name, surname, phone, age,  email);
        Mockito.when(clientDao.getClient(id)).thenReturn(expectedClient);
        Client client = clientService.createClient(name, surname, phone, age, email);

        //THEN
        Assert.assertEquals(expectedClient, client);
    }

    @Test
    public void createClientWithNullObjectTest() {
        //GIVEN
        long id = 1;
        Client expectedClient = null;

        //WHEN
        Mockito.when(clientDao.getClient(id)).thenReturn(expectedClient);

        //THEN
        Assert.assertNull(clientDao.getClient(id));
    }

    @Test
    public void emptyClientListTest() {
        //GIVEN
        final int LIST_SIZE = 0;
        List<Client> clients;

        //WHEN
        clients = new ArrayList<>();
        Mockito.when(clientDao.clientList()).thenReturn(clients);

        //THEN
        Assert.assertEquals(LIST_SIZE, clientDao.clientList().size());
    }

    @Test
    public  void  FilledClientListTest() {
        //GIVEN
        final int LIST_SIZE = 3;
        List<Client> clients;

        //WHEN
        clients = new ArrayList<>();
        clients.add(new Client("Test1", "Test1", "+380970000000", 50, "test1@gmail.com"));
        clients.add(new Client("Test2", "Test2", "+380971111111", 50, "test2@gmail.com"));
        clients.add(new Client("Test3", "Test3", "+380972222222", 50, "test2@gmail.com"));
        Mockito.when(clientDao.clientList()).thenReturn(clients);

        //THEN
        Assert.assertEquals(LIST_SIZE, clientDao.clientList().size());
    }

    @After
    public void tearDown() {
        clientDao = null;
    }
}