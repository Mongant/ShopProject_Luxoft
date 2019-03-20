package com.gorbunov.servlets;

import com.gorbunov.services.ClientService;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteClientServlet extends HttpServlet {

    ClientService clientService;

    public DeleteClientServlet(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        clientService.deleteClient(Long.parseLong(id));
        RequestDispatcher desdatcher = getServletContext().getRequestDispatcher("/adminClientOptions.jsp");

    }
}
