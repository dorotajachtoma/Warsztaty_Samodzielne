package pl.coderslab.crm.web.customer;

import pl.coderslab.crm.dao.CustomerDao;
import pl.coderslab.crm.dao.VehicleDao;
import pl.coderslab.crm.model.Customer;
import pl.coderslab.crm.model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/selectcustomer")
public class SelectCustomerById extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        if(Objects.nonNull(id)) {
            CustomerDao customerDao = new CustomerDao();
            Customer customer = customerDao.findCustomerById(id);
            req.setAttribute("customer", customer);
            getServletContext().getRequestDispatcher("/customer-single.jsp")
                    .forward(req, resp);

        }
    }
}
