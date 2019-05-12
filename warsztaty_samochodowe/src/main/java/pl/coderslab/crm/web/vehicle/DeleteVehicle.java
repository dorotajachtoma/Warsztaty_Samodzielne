package pl.coderslab.crm.web.vehicle;
import pl.coderslab.crm.dao.VehicleDao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/deletevehicle")
public class DeleteVehicle extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        if(Objects.nonNull(id)){
            int vehicleID = Integer.parseInt(id);
            VehicleDao vehicleDao = new VehicleDao();
            vehicleDao.deleteVehicle(vehicleID);
            resp.sendRedirect("http://localhost:8080/warsztaty_samochodowe_war_exploded/vehiclelist");
        }
    }
}
