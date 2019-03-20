package com.gorbunov.servlets;

import com.gorbunov.dao.ClientDao;
import com.gorbunov.dao.impl.ClientDaoImpl;
import com.gorbunov.services.ClientService;
import com.gorbunov.services.impl.ClientServiceImpl;
import com.gorbunov.validator.ValidationService;
import com.gorbunov.validator.ValidationServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class WebApp implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ClientDao clientDao = ClientDaoImpl.getInstance();
        ValidationService validationService = new ValidationServiceImpl();
        ClientService clientService = new ClientServiceImpl(clientDao, validationService);
        new ClientServiceImpl(clientDao, validationService);
        ServletContext servletContext = sce.getServletContext();
        servletContext
                .addServlet("ClientServlet", new ClientServlet(clientService))
                .addMapping("/clients");
        servletContext
                .addServlet("DeleteClientServlet", new DeleteClientServlet(clientService))
                .addMapping("/delete_client");
        servletContext.addServlet("UpdateClientServlet", new UpdateClientServlet(clientService))
                .addMapping("/update_client");
    }
}
