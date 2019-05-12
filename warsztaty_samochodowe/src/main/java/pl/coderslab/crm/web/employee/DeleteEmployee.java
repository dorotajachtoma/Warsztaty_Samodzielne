package pl.coderslab.crm.web.employee;

import pl.coderslab.crm.dao.CustomerDao;
import pl.coderslab.crm.dao.EmployeeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet("/deleteemployee")
public class DeleteEmployee extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        if(Objects.nonNull(id)){
            int employeeId = Integer.parseInt(id);
            EmployeeDao employeeDao = new EmployeeDao();
            employeeDao.delete(employeeId);
            resp.sendRedirect("http://localhost:8080/warsztaty_samochodowe_war_exploded/employeelist");

        }
    }
}
