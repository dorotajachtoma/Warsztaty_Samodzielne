package pl.coderslab.crm.web.orders;

import pl.coderslab.crm.dao.CustomerDao;
import pl.coderslab.crm.dao.EmployeeDao;
import pl.coderslab.crm.dao.OrderDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet("/deleteorder")
public class DeleteOrder extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if(Objects.nonNull(id)){
            int orderId= Integer.parseInt(id);
            OrderDao orderDao = new OrderDao();
            orderDao.delete(orderId);
            resp.sendRedirect("http://localhost:8080/warsztaty_samochodowe_war_exploded/orderlist");
        }
    }
}

