package com.gorbunov.servlets;

import com.gorbunov.domain.Client;
import com.gorbunov.services.ClientService;
import com.gorbunov.validator.BusinessException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ClientServlet extends HttpServlet {

    ClientService clientService;

    public ClientServlet(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        List<Client> clients = clientService.listClients();
        if(!clients.isEmpty()) {
            out.println("<center><h1> Client list</h1></center>");
            for(Client client : clients) {
                out.print("<h4> Client ID: " + client.getId() + "</h4>");
                out.print("<h4> Client name: " + client.getName() + "</h4>");
                out.print("<h4> Client surname: " + client.getSurname() + "</h4>");
                out.print("<h4> Client age: " + client.getAge() + "</h4>");
                out.print("<h4> Phone number: " + client.getPhone() + "</h4>");
                out.print("<h4> Email: " + client.getEmail() + "</h4>");
                out.print("------------------------------------------<br>");
            }
        } else {
            out.print("<center><h1>The client list is empty!</h1></center>");
        }
     }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String age = request.getParameter("age");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        try {
            clientService.createClient(name, surname, phone, Integer.parseInt(age), email);
            response.sendRedirect(url + "/clientsList.jsp");
        } catch(BusinessException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) {
        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String age = request.getParameter("age");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        try {
            clientService.modifyClient(Long.parseLong(id), name, surname, phone, Integer.parseInt(age), email);
            response.sendRedirect(url + "/clientsList.jsp");
        } catch (BusinessException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        String id = request.getParameter("id");
        clientService.deleteClient(Long.parseLong(id));
        response.sendRedirect(url + "/clientsList.jsp");
    }
}
