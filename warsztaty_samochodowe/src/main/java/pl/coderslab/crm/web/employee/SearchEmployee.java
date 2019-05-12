package pl.coderslab.crm.web.employee;

import pl.coderslab.crm.dao.EmployeeDao;
import pl.coderslab.crm.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebEndpoint;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@WebServlet("/searchemployee")
public class SearchEmployee extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/search-employee.jsp")
                .forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String surname= req.getParameter("surname");

        if(Objects.nonNull(surname)){
            EmployeeDao employeeDao = new EmployeeDao();
            List<Employee> employeeList = employeeDao.findEmployeeByNameSurname(surname);
            req.setAttribute("employee",employeeList);
            getServletContext().getRequestDispatcher("/employees-list.jsp")
                    .forward(req,resp);

        }

    }
}
