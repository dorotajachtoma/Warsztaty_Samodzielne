package pl.coderslab.crm.web.vehicle;

import pl.coderslab.crm.dao.OrderDao;
import pl.coderslab.crm.dao.VehicleDao;
import pl.coderslab.crm.model.Order;
import pl.coderslab.crm.model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet("/updatevehicle")
public class UpdateVehicle extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    int id = Integer.parseInt(req.getParameter("id"));
        if (Objects.nonNull(id)) {
            VehicleDao vehicleDao = new VehicleDao();
        Vehicle vehicle = vehicleDao.findVehicleById(id);
        req.setAttribute("vehicle",vehicle);
        getServletContext().getRequestDispatcher("/edit-vehicle.jsp")
                .forward(req, resp);
    } else {
        PrintWriter writer = resp.getWriter();
        writer.append("<a href=" + "http://localhost:8080/warsztaty_samochodowe_war_exploded/homepage" + ">Przejdz do strony glowej</a></body></html>");

    }
}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        String model = req.getParameter("model");
        String brand = req.getParameter("brand");
        String dateOfProduction = req.getParameter("dateOfProduction");
        String numberPlate = req.getParameter("numberPlate");
        String dateNextServie = req.getParameter("dateOfService");
        int customerId = Integer.parseInt(req.getParameter("customerID"));

        Vehicle vehicle = new Vehicle(id,model,brand,dateOfProduction,numberPlate,dateNextServie,customerId);
        VehicleDao vehicleDao = new VehicleDao();
        vehicle = vehicleDao.update(vehicle);
        req.setAttribute("vehicle",vehicle);
        getServletContext().getRequestDispatcher("/edit-vehicle.jsp")
                .forward(req, resp);
        PrintWriter writer = resp.getWriter();
        writer.append("<a href=" + "http://localhost:8080/warsztaty_samochodowe_war_exploded/employeelist" + ">Przejdz do listy klientow</a></body></html>");
    }
}
