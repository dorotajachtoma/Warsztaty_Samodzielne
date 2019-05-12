package pl.coderslab.crm.web.vehicle;

import pl.coderslab.crm.dao.VehicleDao;
import pl.coderslab.crm.model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/vehiclelist")
public class VehicleList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        VehicleDao vehicleDao = new VehicleDao();
        List<Vehicle> vehicles = vehicleDao.readVehicles();
        req.setAttribute("vehicle",vehicles);
        getServletContext().getRequestDispatcher("/vehicle-list.jsp")
                .forward(req,resp);
    }
}
