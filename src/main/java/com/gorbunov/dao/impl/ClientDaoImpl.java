package com.gorbunov.dao.impl;

import com.gorbunov.dao.ClientDao;
import com.gorbunov.domain.Client;
import com.gorbunov.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientDaoImpl implements ClientDao {

    @Autowired
    Client client;

    private Map<Long, Client> clients = new HashMap<>();

    private ClientDaoImpl() {
    }

    @Override
    public void addClient(Client client) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(client);
        transaction.commit();
        session.close();
    }

    @Override
    public Client getClient(long id) {
        Session session =  HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Client client = session.get(Client.class, id);
        session.close();

        return client;
    }

    @Override
    public List<Client> clientList() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Client> clients = (List<Client>) session.createQuery("from Client").list();
        session.close();
        return clients;
    }

    @Override
    public void updateClient(long id, Client client) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(client);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteClient(long id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        client.setId(id);
        session.delete(client);
        transaction.commit();
        session.close();
    }

    @Override
    public boolean duplicatePhone(String phone) {
        boolean duplicatePhone = false;
        for(Map.Entry<Long, Client> pair : clients.entrySet()) {
            if(phone.equals(pair.getValue().getPhone())) {
                duplicatePhone = true;
                break;
            } else {
                duplicatePhone = false;
            }
        }
        return duplicatePhone;
    }
}