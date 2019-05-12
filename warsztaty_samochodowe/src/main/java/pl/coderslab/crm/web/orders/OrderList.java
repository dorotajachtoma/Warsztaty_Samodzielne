package pl.coderslab.crm.web.orders;

import pl.coderslab.crm.dao.OrderDao;
import pl.coderslab.crm.dao.StatusDao;
import pl.coderslab.crm.model.Order;
import pl.coderslab.crm.model.Status;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@WebServlet("/orderlist")
public class OrderList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String statusId = req.getParameter("status_id");
        OrderDao orderDao = new OrderDao();
        List <Order> orders = orderDao.readOrders();
        if(Objects.nonNull(statusId)) {
            StatusDao statusDao = new StatusDao();
            Status status = statusDao.selectById(Integer.parseInt(statusId));
            req.setAttribute("status", status);
        }else{
       req.setAttribute("order", orders);
            getServletContext().getRequestDispatcher("/orders-list.jsp")
                    .forward(req, resp);

        }
    }
}
