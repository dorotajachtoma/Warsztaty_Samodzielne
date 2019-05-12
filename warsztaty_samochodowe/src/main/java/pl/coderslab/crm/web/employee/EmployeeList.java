package pl.coderslab.crm.web.employee;

import pl.coderslab.crm.dao.EmployeeDao;
import pl.coderslab.crm.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/employeelist")
public class EmployeeList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        EmployeeDao employeeDao = new EmployeeDao();
        List<Employee> employeeList = employeeDao.readEmployees();
        req.setAttribute("employee",employeeList);
      getServletContext().getRequestDispatcher("/employees-list.jsp")
                .forward(req,resp);
    }
}
