package pl.coderslab.crm.web.customer;

import pl.coderslab.crm.dao.CustomerDao;
import pl.coderslab.crm.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/customerlist")
public class CustomerList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerDao customerDao = new CustomerDao();
        List<Customer> customerList = customerDao.readCustomers();
        req.setAttribute("customer",customerList);
        getServletContext().getRequestDispatcher("/customer-list.jsp")
                .forward(req,resp);
    }
}
