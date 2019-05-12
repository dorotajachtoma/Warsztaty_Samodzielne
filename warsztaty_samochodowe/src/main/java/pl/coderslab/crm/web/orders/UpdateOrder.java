package pl.coderslab.crm.web.orders;

import pl.coderslab.crm.dao.EmployeeDao;
import pl.coderslab.crm.dao.OrderDao;
import pl.coderslab.crm.model.Employee;
import pl.coderslab.crm.model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet("/updateorder")
public class UpdateOrder extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        if (Objects.nonNull(id)) {
            OrderDao orderDao = new OrderDao();
            Order order = orderDao.findById(id);
            req.setAttribute("order",order);
            getServletContext().getRequestDispatcher("/edit-order.jsp")
                    .forward(req, resp);
        } else {
            PrintWriter writer = resp.getWriter();
            writer.append("<a href=" + "http://localhost:8080/warsztaty_samochodowe_war_exploded/homepage" + ">Przejdz do strony glowej</a></body></html>");

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        String acceptedDate = req.getParameter("acceptedToRepair");
        String plannedDate = req.getParameter("plannedDate");
        String dateOfRepair = req.getParameter("dateOfRepair");
        int employeeID = Integer.parseInt(req.getParameter("employeeID"));
        String descriptionProblem = req.getParameter("descriptionProblem");
        String descriptionFixing = req.getParameter("descriptionFixing");
        String vehicleID = req.getParameter("vehicleID");
        String costOfRepair = req.getParameter("costOfRepair");
        String costOfParts = req.getParameter("costOfParts");
        String costOfEmployee = req.getParameter("costOfEmployee");
        int quantityOfWork = Integer.parseInt(req.getParameter("quantityOfHours"));
        int statusID = Integer.parseInt(req.getParameter("statusID"));

        Order order = new Order(id,acceptedDate,plannedDate,dateOfRepair,employeeID,descriptionProblem,descriptionFixing,vehicleID
                ,costOfRepair,costOfParts,costOfEmployee,quantityOfWork,statusID);
        OrderDao orderDao = new OrderDao();
        order = orderDao.update(order);
        req.setAttribute("order",order);
        getServletContext().getRequestDispatcher("/edit-order.jsp")
                .forward(req, resp);
        PrintWriter writer = resp.getWriter();
        writer.append("<a href=" + "http://localhost:8080/warsztaty_samochodowe_war_exploded/employeelist" + ">Przejdz do listy klientow</a></body></html>");
    }
}

