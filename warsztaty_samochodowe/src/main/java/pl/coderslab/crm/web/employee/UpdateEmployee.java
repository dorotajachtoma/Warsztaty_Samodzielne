package pl.coderslab.crm.web.employee;

import pl.coderslab.crm.dao.CustomerDao;
import pl.coderslab.crm.dao.EmployeeDao;
import pl.coderslab.crm.model.Customer;
import pl.coderslab.crm.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet("/updateemployee")
public class UpdateEmployee extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        if (Objects.nonNull(id)) {
            EmployeeDao employeeDao = new EmployeeDao();
            Employee employee = employeeDao.findEmployeeById(id);
            req.setAttribute("employee", employee);
            getServletContext().getRequestDispatcher("/edit-employee.jsp")
                    .forward(req, resp);
        } else {
            PrintWriter writer = resp.getWriter();
            writer.append("<a href=" + "http://localhost:8080/warsztaty_samochodowe_war_exploded/homepage" + ">Przejdz do strony glowej</a></body></html>");

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String address = req.getParameter("address");
        String phoneNumber = req.getParameter("numberPhone");
        String note = req.getParameter("note");
        String costByHour = req.getParameter("costByHour");

        Employee employee = new Employee(id,name,surname,address,phoneNumber,note,costByHour);
        EmployeeDao employeeDao = new EmployeeDao();
        employee = employeeDao.update(employee);
        req.setAttribute("employee",employee);
        getServletContext().getRequestDispatcher("/edit-employee.jsp")
                .forward(req, resp);
        PrintWriter writer = resp.getWriter();
        writer.append("<a href=" + "http://localhost:8080/warsztaty_samochodowe_war_exploded/employeelist" + ">Przejdz do listy klientow</a></body></html>");
    }
}
