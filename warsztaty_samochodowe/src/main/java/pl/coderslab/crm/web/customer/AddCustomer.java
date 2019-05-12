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

@WebServlet("/addcustomer")
public class AddCustomer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                getServletContext().getRequestDispatcher("/customer.jsp")
                        .forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String date = req.getParameter("date");
        PrintWriter writer = resp.getWriter();


        if(!id.equals("") && !name.equals("") && !surname.equals("") && !date.equals("")) {
            int customerid = Integer.parseInt(id);
            Customer customer = new Customer(customerid, name, surname, date);
            CustomerDao customerDao = new CustomerDao();
            customerDao.create(customer);
            resp.sendRedirect("http://localhost:8080/warsztaty_samochodowe_war_exploded/customerlist");
        }else{
            writer.append("<html><body>Nie mozna dodac klienta bez danych!")
                    .append("<a href=" + "http://localhost:8080/warsztaty_samochodowe_war_exploded/addcustomer" +">Kliknij ponownie aby przejsc do wprowadzania klienta</a>");
        }
    }
}
