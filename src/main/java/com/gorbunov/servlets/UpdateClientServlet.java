package com.gorbunov.servlets;

import com.gorbunov.services.ClientService;
import com.gorbunov.validator.BusinessException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateClientServlet extends HttpServlet {

    ClientService clientService;

    public UpdateClientServlet(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String age = req.getParameter("age");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        try {
            clientService.modifyClient(Long.parseLong(id), name, surname, phone, Integer.parseInt(age), email);
        } catch (BusinessException e) {
            e.printStackTrace();
        }

    }
}
