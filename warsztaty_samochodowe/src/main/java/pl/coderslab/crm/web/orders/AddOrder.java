package pl.coderslab.crm.web.orders;

import pl.coderslab.crm.dao.OrderDao;
import pl.coderslab.crm.model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet("/addorder")
public class AddOrder extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/order.jsp")
                .forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            String orderID = req.getParameter("id");
            String acceptedDate = req.getParameter("acceptedToRepair");
            String plannedDate = req.getParameter("plannedDate");
            String dateOfRepair = req.getParameter("dateOfRepair");
            String employeeID = req.getParameter("employeeID");
            String descriptionProblem = req.getParameter("descriptionProblem");
            String descriptionFixing = req.getParameter("descriptionFixing");
            String vehicleID = req.getParameter("vehicleID");
            String costOfRepair = req.getParameter("costOfRepair");
            String costOfParts = req.getParameter("costOfParts");
            String costOfEmployee = req.getParameter("costOfEmployee");
            String quantityOfWork = req.getParameter("quantityOfHours");
            String statusID = req.getParameter("statusID");

            if(Objects.nonNull(employeeID) && Objects.nonNull(vehicleID) && Objects.nonNull(statusID)) {
                int orderid = Integer.parseInt(orderID);
                int employee = Integer.parseInt(employeeID);
                int status = Integer.parseInt(statusID);
                int quantity = Integer.parseInt(quantityOfWork);
                Order order = new Order(orderid,acceptedDate,plannedDate,dateOfRepair,employee,descriptionProblem,descriptionFixing,vehicleID
                        ,costOfRepair,costOfParts,costOfEmployee,quantity,status);
                OrderDao orderDao = new OrderDao();
                orderDao.createOrder(order);
                resp.sendRedirect("http://localhost:8080/warsztaty_samochodowe_war_exploded/orderlist");
            }
    }
}
