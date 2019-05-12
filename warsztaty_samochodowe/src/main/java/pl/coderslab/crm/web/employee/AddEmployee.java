package pl.coderslab.crm.web.employee;

import pl.coderslab.crm.dao.EmployeeDao;
import pl.coderslab.crm.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet("/addemployee")
public class AddEmployee extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            getServletContext().getRequestDispatcher("/employee.jsp")
                    .forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            String id = req.getParameter("id");
            String name = req.getParameter("name");
            String surname = req.getParameter("surname");
            String address = req.getParameter("address");
            String phoneNumber = req.getParameter("phoneNumber");
            String note = req.getParameter("note");
            String costByHour = req.getParameter("costByHour");

            if(Objects.nonNull(id)){
                int employeeId = Integer.parseInt(id);
                EmployeeDao employeeDao = new EmployeeDao();
                Employee employee = new Employee(employeeId,name,surname,address,phoneNumber,note,costByHour);
                employeeDao.create(employee);
                PrintWriter writer = resp.getWriter();
                resp.sendRedirect("http://localhost:8080/warsztaty_samochodowe_war_exploded/employeelist");
            }
    }
}
