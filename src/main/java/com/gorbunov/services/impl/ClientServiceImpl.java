package com.gorbunov.services.impl;

import com.gorbunov.dao.ClientDao;
import com.gorbunov.domain.Client;
import com.gorbunov.services.ClientService;
import com.gorbunov.validator.BusinessException;
import com.gorbunov.validator.ValidationService;

import java.util.List;

public class ClientServiceImpl implements ClientService {

    private ClientDao clientDao;
    private ValidationService validationService;

    public ClientServiceImpl(ClientDao clientDao, ValidationService validationService) {
        this.clientDao = clientDao;
        this.validationService = validationService;
    }

    @Override
    public void createClient(String name, String phone, String surname) {
            Client client = new Client(name,surname, phone);
            clientDao.addClient(client);
    }

    @Override
    public Client createClient(String name, String surname, String phone, int age, String email) throws BusinessException {
        Client client = null;
        if(!clientDao.duplicatePhone(phone)) {
            validationService.validateAge(age);
            validationService.validatePhoneNum(phone);
            validationService.validateEmail(email);
            client = new Client(name, surname, phone, age, email);
            clientDao.addClient(client);
        } else {
            System.err.println("Phone number is not unique!");
        }
        return client;
    }

    @Override
    public void modifyClient(long id, Client client) {
        client.setId(id);
        if(clientDao.modifyClient(id, client)) {
            System.out.println("Client id: " + id + " was modify successfully!");
        } else {
            System.err.println("Client by id: " + id + " was not found!");
        }
    }

    @Override
    public void deleteClient(long id) {
        if(clientDao.deleteClient(id)) {
            System.out.println("Client by id: " + id + " was successfully deleted!");
        } else {
            System.err.print("Client by id: " + id + " was not found!");
        }
    }

    @Override
    public List<Client> listClients() {
        return clientDao.clientList();
    }
}