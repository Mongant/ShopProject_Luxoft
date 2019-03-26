package com.gorbunov.servlets;

import com.gorbunov.domain.ProductContainer;
import com.gorbunov.services.ProductContainerService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;

public class ProductContainerServlet extends HttpServlet {

    ProductContainerService productContainerService;

    public ProductContainerServlet(ProductContainerService productContainerService) {
        this.productContainerService = productContainerService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String refId = request.getSession().getId();
        ProductContainer productContainer = productContainerService.showProductContainer(refId);
        StringBuilder sb = new StringBuilder();
        Iterator it = productContainer.getProductsContainer().entrySet().iterator();
        if(!productContainer.getProductsContainer().isEmpty()) {
            out.println("<center><h1>Product container list</h1></center>");
            while(it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                sb.append("\nID: ").append(pair.getKey()).append(" ").append(pair.getValue());
                out.print("<h4>" + sb.toString() + "</h4>");
            }
            System.out.println(sb.toString());
        } else {
            out.print("<center><h1>The product container list is empty!</h1></center>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        String refId = request.getSession().getId();
        String productId = request.getParameter("productId");
        productContainerService.addProductContainer(Long.parseLong(productId), refId);
        response.sendRedirect(url + "/productContainerList.jsp");
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        String refId = request.getSession().getId();
        String id = request.getParameter("id");
        productContainerService.deleteProductContainer(Long.parseLong(id), refId);
        response.sendRedirect(url + "/productContainerList.jsp");
    }
}
