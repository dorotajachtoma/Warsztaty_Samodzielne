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
import java.util.List;
import java.util.Objects;

@WebServlet("/searchcustomer")
public class SearchCustomer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/search-customer.jsp")
                .forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String surname = req.getParameter("surname");

                if(Objects.nonNull(surname)){
                    CustomerDao customerDao = new CustomerDao();
                    List<Customer>  customer = customerDao.findCustomerByNameSurname(surname);
                    req.setAttribute("customer",customer);
                    getServletContext().getRequestDispatcher("/customer-list.jsp")
                            .forward(req,resp);
                }else{
                    PrintWriter writer = resp.getWriter();
                    writer.append("<html><body>Klient o podanym nazwisku nie istnieje w bazie")
                            .append("<a hre=" + "http://localhost:8080/warsztaty_samochodowe_war_exploded/searchcustomer" +">Wyszukaj ponownie klienta</a>");
                }
    }
}
