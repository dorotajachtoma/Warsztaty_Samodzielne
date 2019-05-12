package pl.coderslab.crm.dao;
import pl.coderslab.crm.model.Customer;
import pl.coderslab.crm.model.Employee;
import pl.coderslab.crm.utils.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {


    private static final String SELECT_ALL_EMPLOYEES = "SELECT * FROM employee;";
    private static final String SELECT_BY_NAME_SURNAME = "SELECT * FROM employee WHERE surname = ?;";
    private static final String CREATE_EMPLOYEE = "INSERT INTO employee (name,surname,address,phone_number,note, cost_by_hour) VALUES (?,?,?,?,?,?);";
    private static final String DELETE_EMPLOYEE = "DELETE FROM employee WHERE id = ?; ";
    private static final String UPDATE_EMPLOYEE = "UPDATE employee SET name  = ?, surname  = ?, address = ?, phone_number  = ?, note  = ? , cost_by_hour = ? WHERE id  = ?;";
    private static final String SELECT_EMLOYEE_BY_ID = "SELECT * FROM employee WHERE id=?;";


    public List<Employee> readEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_EMPLOYEES)
        ) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Employee employee = new Employee();
                    employee.setId(resultSet.getInt("id"));
                    employee.setName(resultSet.getString("name"));
                    employee.setSurname(resultSet.getString("surname"));
                    employee.setAddress(resultSet.getString("address"));
                    employee.setPhoneNumber(resultSet.getString("phone_number"));
                    employee.setNote(resultSet.getString("note"));
                    employee.setSalaryByHour(resultSet.getString("cost_by_hour"));
                    employees.add(employee);
                }
                return  employees;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employees;

    }


    public List<Employee> findEmployeeByNameSurname(String surname) {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_NAME_SURNAME)
        ) {

            statement.setString(1, surname);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Employee employee = new Employee();
                    employee.setId(resultSet.getInt("id"));
                    employee.setName(resultSet.getString("name"));
                    employee.setSurname(resultSet.getString("surname"));
                    employee.setAddress(resultSet.getString("address"));
                    employee.setPhoneNumber(resultSet.getString("phone_number"));
                    employee.setNote(resultSet.getString("note"));
                    employee.setSalaryByHour(resultSet.getString("cost_by_hour"));
                    employees.add(employee);
                }
                return employees;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employees;

    }


    public Employee create(Employee employee) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE_EMPLOYEE,
                     PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getSurname());
            statement.setString(3, employee.getAddress());
            statement.setString(4, employee.getAddress());
            statement.setString(5, employee.getNote());
            statement.setString(6, employee.getSalaryByHour());
            int result = statement.executeUpdate();

            if (result != 1) {
                throw new RuntimeException("Execute update returned " + result);
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.first()) {
                    employee.setId(generatedKeys.getInt(1));
                    return employee;
                } else {
                    throw new RuntimeException("Generated key was not found");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public void delete(Integer employeeId) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEE)) {
            statement.setInt(1, employeeId);
            statement.executeUpdate();
            boolean deleted = statement.execute();
            if (!deleted) {
                throw new Exception("Employee not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Employee update(Employee employee) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_EMPLOYEE)) {
            statement.setInt(7, employee.getId());
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getSurname());
            statement.setString(3, employee.getAddress());
            statement.setString(4, employee.getPhoneNumber());
            statement.setString(5, employee.getNote());
            statement.setString(6, employee.getSalaryByHour());
            statement.executeUpdate();
            return employee;
        } catch (Exception e) {
            e.printStackTrace();
        }
            return employee;
    }

    public Employee findEmployeeById(Integer employeeId) {
        Employee employee = new Employee();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_EMLOYEE_BY_ID)
        ) {

            statement.setInt(1, employeeId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    employee.setId(resultSet.getInt("id"));
                    employee.setName(resultSet.getString("name"));
                    employee.setSurname(resultSet.getString("surname"));
                    employee.setAddress(resultSet.getString("address"));
                    employee.setPhoneNumber(resultSet.getString("phone_number"));
                    employee.setNote(resultSet.getString("note"));
                    employee.setSalaryByHour(resultSet.getString("cost_by_hour"));
                }
                return employee;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;

    }



}