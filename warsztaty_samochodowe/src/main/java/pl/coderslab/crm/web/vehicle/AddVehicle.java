package pl.coderslab.crm.web.vehicle;

import pl.coderslab.crm.dao.VehicleDao;
import pl.coderslab.crm.model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet("/addvehicle")
public class AddVehicle extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/vehicle.jsp")
                .forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("vehicleID");
        String model = req.getParameter("model");
        String brand = req.getParameter("brand");
        String dateOfProduction = req.getParameter("dateOfProduction");
        String numberPlate = req.getParameter("numberPlate");
        String dateNextServie = req.getParameter("dateOfService");
        String customerId = req.getParameter("customerID");

        if (Objects.nonNull(id) && Objects.nonNull(customerId)){
            int vehicleId = Integer.parseInt(id);
            int customer = Integer.parseInt(customerId);
            VehicleDao vehicleDao = new VehicleDao();
            Vehicle vehicle = new Vehicle(vehicleId,model,brand,dateOfProduction,numberPlate,dateNextServie,customer);
            vehicleDao.createVehicle(vehicle);
            PrintWriter writer = resp.getWriter();
            resp.sendRedirect("http://localhost:8080/warsztaty_samochodowe_war_exploded/vehiclelist");
      }
    }
}
