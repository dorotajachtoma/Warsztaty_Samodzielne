package pl.coderslab.crm.web.raports;

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

@WebServlet("/earnings")
public class Earnings extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        double totalCostOfEmployees = 0;
        double totalCostOfRepair = 0;
        double result = 0;
        OrderDao orderDao = new OrderDao();
        List<Order> orders = orderDao.readOrders();
        if(Objects.nonNull(orders)){
        for(Order o : orders) {
            String costOfEmployee = o.getCostOfEmployee();
            String costOfRepair = o.getCostOfFixing();
            int quantityOfHours = o.getQuantityOfWorkByHour();
            double parsedCostOfEmployee = Double.parseDouble(costOfEmployee);
            double parsedCostOfRepair = Double.parseDouble(costOfRepair);
            double employee = parsedCostOfEmployee * quantityOfHours;
            totalCostOfEmployees += employee;
            totalCostOfRepair += parsedCostOfRepair;
            result = totalCostOfRepair - totalCostOfEmployees;
        }
                    req.setAttribute("costOfEmployees",totalCostOfEmployees);
                    req.setAttribute("costOfRepair",totalCostOfRepair);
                    req.setAttribute("earnings",result);
                    getServletContext().getRequestDispatcher("/earnings.jsp")
                            .forward(req,resp);

            }

        }
    }


