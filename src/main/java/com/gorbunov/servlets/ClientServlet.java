// Правильно оформить сервлеты с методами doGet, doPost,doDelete
// Закончить клиента с doPut для обновления клиента

package com.gorbunov.servlets;

import com.gorbunov.domain.Client;
import com.gorbunov.services.ClientService;
import com.gorbunov.validator.BusinessException;

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        List<Client> clients = clientService.listClients();
        if(clients != null) {
            out.println("<center><h1> Client list</h1></center>");
            for(Client client : clientService.listClients()) {
                out.print("<h5> Client name: " + client.getName() + "</h5>");
                out.print("<h5> Client surname: " + client.getSurname() + "</h5>");
                out.print("<h5> Client age: " + client.getAge() + "</h5>");
                out.print("<h5> Phone number: " + client.getPhone() + "</h5>");
                out.print("<h5> Email: "+ client.getEmail()+"</h5>");
                out.print("------------------------------------------<br>");
            }
        } else {
            out.println("<h5>Client list is empty!</h5>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String age = request.getParameter("age");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        try {
            clientService.createClient(name, surname, phone, Integer.parseInt(age),email);
        } catch (BusinessException e) {
            e.printStackTrace();
        }
    }

//    @Override
//    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String id = req.getParameter("id");
//        clientService.deleteClient(Long.parseLong(id));
//    }
}
