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
import java.util.Objects;

@WebServlet("/searchvehicle")
public class SearchVehicle extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/search-vehicle.jsp")
                .forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

                String brand = req.getParameter("brand");

                if(Objects.nonNull(brand)){
                    VehicleDao vehicleDao = new VehicleDao();
                    List<Vehicle> vehicleList = vehicleDao.findVehicleByBrand(brand);
                    req.setAttribute("vehicle",vehicleList);
                    getServletContext().getRequestDispatcher("/vehicle-list.jsp")
                            .forward(req,resp);
                }
    }
}
