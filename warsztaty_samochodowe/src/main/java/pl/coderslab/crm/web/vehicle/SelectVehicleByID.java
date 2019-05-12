package pl.coderslab.crm.web.vehicle;

import pl.coderslab.crm.dao.VehicleDao;
import pl.coderslab.crm.model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/selectvehicle")
public class SelectVehicleByID extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String vehicleId = req.getParameter("id");
        if(Objects.nonNull(vehicleId)){
            VehicleDao vehicleDao = new VehicleDao();
            Vehicle vehicle = vehicleDao.findVehicleById(Integer.parseInt(vehicleId));
            req.setAttribute("vehicle",vehicle);
            getServletContext().getRequestDispatcher("/vehicle-single.jsp")
                    .forward(req,resp);

        }
    }
}
