package pl.coderslab.crm.web.status;

import pl.coderslab.crm.dao.StatusDao;
import pl.coderslab.crm.model.Status;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/selectstatus")
public class SelectStatusById extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String statusId = req.getParameter("id");
        if(Objects.nonNull(statusId)){
            StatusDao statusDao = new StatusDao();
            Status status  = statusDao.selectById(Integer.parseInt(statusId));
            req.setAttribute("status",status);
            getServletContext().getRequestDispatcher("/status-single.jsp")
                    .forward(req,resp);
        }
    }
}
