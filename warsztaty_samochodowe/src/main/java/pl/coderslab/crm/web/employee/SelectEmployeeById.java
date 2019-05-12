package pl.coderslab.crm.web.employee;

import pl.coderslab.crm.dao.EmployeeDao;
import pl.coderslab.crm.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/selectemployee")
public class SelectEmployeeById extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String employeeId = req.getParameter("id");
        if(Objects.nonNull(employeeId)){
            EmployeeDao employeeDao = new EmployeeDao();
            Employee employee = employeeDao.findEmployeeById(Integer.parseInt(employeeId));
            req.setAttribute("employee", employee);
            getServletContext().getRequestDispatcher("/employee-single.jsp")
                    .forward(req,resp);
        }

    }
}
