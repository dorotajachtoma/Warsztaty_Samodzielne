package pl.coderslab.crm.web.raports;
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
import java.util.List;
import java.util.Objects;

@WebServlet("/raport-sum-hours")
public class RaportSumHours extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String emoloyeeId = req.getParameter("id");
        if(Objects.nonNull(emoloyeeId)){
            EmployeeDao employeeDao = new EmployeeDao();
            Employee employee = employeeDao.findEmployeeById(Integer.parseInt(emoloyeeId));
            int sum = 0;
            OrderDao orderDao = new OrderDao();
            List<Order> orders = orderDao.selectOrdersByEmployee(Integer.parseInt(emoloyeeId));
            for(Order o :orders) {
                sum  += o.getQuantityOfWorkByHour();
            }
            req.setAttribute("sum",sum);
            req.setAttribute("employee",employee);
            getServletContext().getRequestDispatcher("/raport-sum-hours.jsp")
                    .forward(req,resp);
        }
    }
}

