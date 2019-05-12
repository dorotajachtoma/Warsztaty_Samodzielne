package pl.coderslab.crm.dao;


import pl.coderslab.crm.model.Employee;
import pl.coderslab.crm.model.Order;
import pl.coderslab.crm.utils.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    private static final String SELECT_ALL_ORDERS = "SELECT * FROM orders order by accepted_to_repair desc;";
    private static final String SELECT_BY_DATE = "SELECT * FROM orders WHERE date_of_repair  = ?;";
    private static final String CREATE_ORDER = "INSERT INTO orders (order_id,accepted_to_repair,planned_date_of_repair,date_of_repair,employee_id,description_of_problem, description_of_repair,vehicle_id,cost_of_repair,cost_of_car_parts,cost_of_employee,quantity_of_hours,status_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);";
    private static final String DELETE_ORDER = "DELETE FROM orders WHERE order_id = ? ; ";
    private static final String UPDATE_ORDER = "UPDATE orders SET accepted_to_repair = ? ,planned_date_of_repair = ? ,date_of_repair = ? ,employee_id = ? ,description_of_problem =  ?, description_of_repair = ?,vehicle_id = ?,cost_of_repair = ?,cost_of_car_parts = ? ,cost_of_employee = ? ,quantity_of_hours = ? ,status_id = ?  WHERE order_id  = ?;";
    private static final String SELECT_ORDER_BY_ID = "SELECT * FROM orders WHERE order_id=?;";
    private static final String SELECT_BY_EMPLOYEE_ID = "SELECT *  FROM orders WHERE employee_id = ? and date_add(date_of_repair, interval 30 day);";


    public List<Order> readOrders() {
        List<Order> orders = new ArrayList<>();

        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_ORDERS)
        ) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Order order = new Order();
                    order.setId(resultSet.getInt("order_id"));
                    order.setAcceptedtoRepair(resultSet.getString("accepted_to_repair"));
                    order.setPlannedDateOfRepair(resultSet.getString("planned_date_of_repair"));
                    order.setStartOfRepair(resultSet.getString("date_of_repair"));
                    order.setEmployeeId(resultSet.getInt("employee_id"));
                    order.setDescriptionOfProblem(resultSet.getString("description_of_problem"));
                    order.setDescriptionOfFixing(resultSet.getString("description_of_repair"));
                    order.setIdOfVehicle(resultSet.getString("vehicle_id"));
                    order.setCostOfFixing(resultSet.getString("cost_of_repair"));
                    order.setCostOfCarParts(resultSet.getString("cost_of_car_parts"));
                    order.setCostOfEmployee(resultSet.getString("cost_of_employee"));
                    order.setQuantityOfWorkByHour(resultSet.getInt("quantity_of_hours"));
                    order.setStatusId(resultSet.getInt("status_id"));
                    orders.add(order);
                }
                return orders;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;

    }


    public List<Order> findOrderByDate(String date) {
        List<Order> orders = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_DATE)
        ) {
            statement.setString(1, date);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Order order = new Order();
                    order.setId(resultSet.getInt("order_id"));
                    order.setAcceptedtoRepair(resultSet.getString("accepted_to_repair"));
                    order.setPlannedDateOfRepair(resultSet.getString("planned_date_of_repair"));
                    order.setStartOfRepair(resultSet.getString("date_of_repair"));
                    order.setEmployeeId(resultSet.getInt("employee_id"));
                    order.setDescriptionOfProblem(resultSet.getString("description_of_problem"));
                    order.setDescriptionOfFixing(resultSet.getString("description_of_repair"));
                    order.setIdOfVehicle(resultSet.getString("vehicle_id"));
                    order.setCostOfFixing(resultSet.getString("cost_of_repair"));
                    order.setCostOfCarParts(resultSet.getString("cost_of_car_parts"));
                    order.setCostOfEmployee(resultSet.getString("cost_of_employee"));
                    order.setQuantityOfWorkByHour(resultSet.getInt("quantity_of_hours"));
                    order.setStatusId(resultSet.getInt("status_id"));
                    orders.add(order);
                }
                return orders;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;

    }


    public Order createOrder(Order order) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE_ORDER,
                     PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, order.getId());
            statement.setString(2, order.getAcceptedtoRepair());
            statement.setString(3, order.getPlannedDateOfRepair());
            statement.setString(4, order.getStartOfRepair());
            statement.setInt(5, order.getEmployeeId());
            statement.setString(6, order.getDescriptionOfProblem());
            statement.setString(7, order.getDescriptionOfFixing());
            statement.setString(8, order.getIdOfVehicle());
            statement.setString(9, order.getCostOfFixing());
            statement.setString(10, order.getCostOfCarParts());
            statement.setString(11, order.getCostOfEmployee());
            statement.setInt(12, order.getQuantityOfWorkByHour());
            statement.setInt(13, order.getStatusId());
            int result = statement.executeUpdate();

            if (result != 1) {
                throw new RuntimeException("Execute update returned " + result);
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.first()) {
                    order.setId(generatedKeys.getInt(1));
                    return order;
                } else {
                    throw new RuntimeException("Generated key was not found");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public void delete(Integer orderId) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_ORDER)) {
            statement.setInt(1, orderId);
            statement.executeUpdate();

            boolean deleted = statement.execute();
            if (!deleted) {
                throw new Exception("Order not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Order update(Order order) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_ORDER)) {
            statement.setString(1, order.getAcceptedtoRepair());
            statement.setString(2, order.getPlannedDateOfRepair());
            statement.setString(3, order.getStartOfRepair());
            statement.setInt(4, order.getEmployeeId());
            statement.setString(5, order.getDescriptionOfProblem());
            statement.setString(6, order.getDescriptionOfFixing());
            statement.setString(7, order.getIdOfVehicle());
            statement.setString(8, order.getCostOfFixing());
            statement.setString(9, order.getCostOfCarParts());
            statement.setString(10, order.getCostOfEmployee());
            statement.setInt(11, order.getQuantityOfWorkByHour());
            statement.setInt(12, order.getStatusId());
            statement.setInt(13, order.getId());
            statement.executeUpdate();
            return order;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return order;
    }

    public Order findById(Integer orderId) {
        Order order = new Order();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ORDER_BY_ID)
        ) {
            statement.setInt(1, orderId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    order.setId(resultSet.getInt("order_id"));
                    order.setAcceptedtoRepair(resultSet.getString("accepted_to_repair"));
                    order.setPlannedDateOfRepair(resultSet.getString("planned_date_of_repair"));
                    order.setStartOfRepair(resultSet.getString("date_of_repair"));
                    order.setEmployeeId(resultSet.getInt("employee_id"));
                    order.setDescriptionOfProblem(resultSet.getString("description_of_problem"));
                    order.setDescriptionOfFixing(resultSet.getString("description_of_repair"));
                    order.setIdOfVehicle(resultSet.getString("vehicle_id"));
                    order.setCostOfFixing(resultSet.getString("cost_of_repair"));
                    order.setCostOfCarParts(resultSet.getString("cost_of_car_parts"));
                    order.setCostOfEmployee(resultSet.getString("cost_of_employee"));
                    order.setQuantityOfWorkByHour(resultSet.getInt("quantity_of_hours"));
                    order.setStatusId(resultSet.getInt("status_id"));
                }
                return order;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return order;
    }
    public List<Order> selectOrdersByEmployee(Integer employeeId) {
        List<Order> orders = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_EMPLOYEE_ID)
        ) {
            statement.setInt(1, employeeId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Order order = new Order();
                    order.setId(resultSet.getInt("order_id"));
                    order.setAcceptedtoRepair(resultSet.getString("accepted_to_repair"));
                    order.setPlannedDateOfRepair(resultSet.getString("planned_date_of_repair"));
                    order.setStartOfRepair(resultSet.getString("date_of_repair"));
                    order.setEmployeeId(resultSet.getInt("employee_id"));
                    order.setDescriptionOfProblem(resultSet.getString("description_of_problem"));
                    order.setDescriptionOfFixing(resultSet.getString("description_of_repair"));
                    order.setIdOfVehicle(resultSet.getString("vehicle_id"));
                    order.setCostOfFixing(resultSet.getString("cost_of_repair"));
                    order.setCostOfCarParts(resultSet.getString("cost_of_car_parts"));
                    order.setCostOfEmployee(resultSet.getString("cost_of_employee"));
                    order.setQuantityOfWorkByHour(resultSet.getInt("quantity_of_hours"));
                    order.setStatusId(resultSet.getInt("status_id"));
                    orders.add(order);
                }
                return orders;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;

    }

}
