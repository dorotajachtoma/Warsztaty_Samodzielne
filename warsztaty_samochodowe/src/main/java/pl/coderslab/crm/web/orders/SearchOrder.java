package pl.coderslab.crm.web.orders;

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
import java.util.StringTokenizer;

@WebServlet("/searchorder")
public class SearchOrder extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/search-order.jsp")
                .forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String date = req.getParameter("date");


        if(Objects.nonNull(date)){
            String[] tokens = date.split("-");
            String newDate = tokens[0] + "-" + tokens[1] + "-" + tokens[2];
            System.out.println(newDate);
            OrderDao orderDao = new OrderDao();
            List<Order> orderList = orderDao.findOrderByDate(newDate);
            req.setAttribute("order",orderList);
            getServletContext().getRequestDispatcher("/orders-list.jsp")
                    .forward(req,resp);


        }
    }
}
