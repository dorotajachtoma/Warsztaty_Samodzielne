package pl.coderslab.crm.dao;

import pl.coderslab.crm.model.Employee;
import pl.coderslab.crm.model.Vehicle;
import pl.coderslab.crm.utils.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VehicleDao {

    private static final String SELECT_ALL_VEHICLES = "SELECT * FROM vehicle;";
    private static final String SELECT_BY_BRAND = "SELECT * FROM vehicle where brand = ?;";
    private static final String CREATE_VEHICLE = "INSERT INTO vehicle (vehicle_id,model,brand,year_of_production, number_plate,date_next_service,customer_id) VALUES (?,?,?,?,?,?,?);";
    private static final String DELETE_VEHICLE = "DELETE FROM vehicle WHERE vehicle_id = ? ; ";
    private static final String UPDATE_VEHICLE = "UPDATE vehicle SET model  = ?, brand  = ?, year_of_production = ?, number_plate  = ?, date_next_service  = ? , customer_id = ? WHERE vehicle_id  = ?;";
    private static final String SELECT_VEHICLE_BY_ID = "SELECT * FROM vehicle WHERE vehicle_id =?;";

    public List<Vehicle> readVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_VEHICLES)
        ) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Vehicle vehicle = new Vehicle();

                    vehicle.setId(resultSet.getInt("vehicle_id"));
                    vehicle.setModel(resultSet.getString("model"));
                    vehicle.setBrand(resultSet.getString("brand"));
                    vehicle.setDateOfProduction(resultSet.getString("year_of_production"));
                    vehicle.setNumberPlate(resultSet.getString("number_plate"));
                    vehicle.setDateOfNextService(resultSet.getString("date_next_service"));
                    vehicle.setCustomerId(resultSet.getInt("customer_id"));

                    vehicles.add(vehicle);
                }
                return  vehicles;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vehicles;

    }


    public List<Vehicle> findVehicleByBrand(String brand) {

        List<Vehicle> vehicles = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_BRAND)
        ) {
            statement.setString(1, brand);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Vehicle vehicle = new Vehicle();
                    vehicle.setId(resultSet.getInt("vehicle_id"));
                    vehicle.setModel(resultSet.getString("model"));
                    vehicle.setBrand(resultSet.getString("brand"));
                    vehicle.setDateOfProduction(resultSet.getString("year_of_production"));
                    vehicle.setNumberPlate(resultSet.getString("number_plate"));
                    vehicle.setDateOfNextService(resultSet.getString("date_next_service"));
                    vehicle.setCustomerId(resultSet.getInt("customer_id"));
                    vehicles.add(vehicle);
                }
                return vehicles;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vehicles;

    }


    public Vehicle createVehicle(Vehicle vehicle) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE_VEHICLE,
                     PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1,vehicle.getId());
            statement.setString(2,vehicle.getModel());
            statement.setString(3,vehicle.getBrand());
            statement.setString(4,vehicle.getDateOfProduction());
            statement.setString(5,vehicle.getNumberPlate());
            statement.setString(6,vehicle.getDateOfNextService());
            statement.setInt(7,vehicle.getCustomerId());
            int result = statement.executeUpdate();

            if (result != 1) {
                throw new RuntimeException("Execute update returned " + result);
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.first()) {
                    vehicle.setId(generatedKeys.getInt(1));
                    return vehicle;
                } else {
                    throw new RuntimeException("Generated key was not found");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    public void deleteVehicle(Integer vehicleId){
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_VEHICLE)) {
            statement.setInt(1, vehicleId);
            statement.executeUpdate();

            boolean deleted = statement.execute();
            if (!deleted) {
                throw new Exception("Vehicle not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Vehicle update(Vehicle vehicle) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_VEHICLE)) {
            statement.setInt(7,vehicle.getId());
            statement.setString(1,vehicle.getModel());
            statement.setString(2,vehicle.getBrand());
            statement.setString(3,vehicle.getDateOfProduction());
            statement.setString(4,vehicle.getNumberPlate());
            statement.setString(5,vehicle.getDateOfNextService());
            statement.setInt(6,vehicle.getCustomerId());
            statement.executeUpdate();
            return vehicle;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vehicle;
    }

    public Vehicle findVehicleById(Integer vehicleId) {
        Vehicle vehicle = new Vehicle();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_VEHICLE_BY_ID)
        ) {

            statement.setInt(1, vehicleId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    vehicle.setId(resultSet.getInt("vehicle_id"));
                    vehicle.setModel(resultSet.getString("model"));
                    vehicle.setBrand(resultSet.getString("brand"));
                    vehicle.setDateOfProduction(resultSet.getString("year_of_production"));
                    vehicle.setNumberPlate(resultSet.getString("number_plate"));
                    vehicle.setDateOfNextService(resultSet.getString("date_next_service"));
                    vehicle.setCustomerId(resultSet.getInt("customer_id"));
                }
                return vehicle;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vehicle;

    }
}



