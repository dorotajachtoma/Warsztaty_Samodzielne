package pl.coderslab.crm.web.employee;

import pl.coderslab.crm.dao.EmployeeDao;
import pl.coderslab.crm.dao.OrderDao;
import pl.coderslab.crm.model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@WebServlet("/selectallorders")
public class SelectAllOrders extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String employeeid = req.getParameter("id");
        if(Objects.nonNull(employeeid)){
            OrderDao orderDao = new OrderDao();
            List<Order> orders = orderDao.selectOrdersByEmployee(Integer.parseInt(employeeid));
            req.setAttribute("order",orders);
            getServletContext().getRequestDispatcher("/orders-list.jsp")
                    .forward(req,resp);
        }
    }
}
