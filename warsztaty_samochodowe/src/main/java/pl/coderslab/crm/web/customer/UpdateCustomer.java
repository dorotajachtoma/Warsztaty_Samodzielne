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

@WebServlet("/updatecustomer")
public class UpdateCustomer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        if(Objects.nonNull(id)) {
            CustomerDao customerDao = new CustomerDao();
            Customer customer = customerDao.findCustomerById(id);
            req.setAttribute("customer", customer);
            getServletContext().getRequestDispatcher("/edit-customer.jsp")
                    .forward(req, resp);

        }else{
            PrintWriter writer = resp.getWriter();
            writer.append("<a href=" + "http://localhost:8080/warsztaty_samochodowe_war_exploded/homepage" +">Przejdz do strony glowej</a></body></html>");

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String dateOfBirth = req.getParameter("date");

        Customer customer = new Customer(id,name,surname,dateOfBirth);
        CustomerDao customerDao = new CustomerDao();
        customer = customerDao.update(customer);
        req.setAttribute("customer",customer);
        getServletContext().getRequestDispatcher("/edit-customer.jsp")
                .forward(req, resp);
        }
    }


