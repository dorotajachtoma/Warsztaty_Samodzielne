package pl.coderslab.crm.web.customer;

import pl.coderslab.crm.dao.CustomerDao;
import pl.coderslab.crm.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet("/deletecustomer")
public class DeleteCustomer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        if(Objects.nonNull(id)){
            int customerID = Integer.parseInt(id);
            CustomerDao customerDao = new CustomerDao();
            customerDao.delete(customerID);
            resp.sendRedirect("http://localhost:8080/warsztaty_samochodowe_war_exploded/customerlist");
        }
    }
}
