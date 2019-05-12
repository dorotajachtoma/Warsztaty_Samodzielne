package pl.coderslab.crm.dao;
import pl.coderslab.crm.model.Customer;
import pl.coderslab.crm.utils.DbUtil;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {

    private static final String SELECT_ALL_CUSTOMERS = "SELECT * FROM customer;";
    private static final String SELECT_BY_NAME_SURNAME = "SELECT * FROM customer WHERE surname = ?;";
    private static final String CREATE_CUSTOMER = "INSERT INTO customer (id,customer_name,surname,date_of_birth) VALUES (?,?,?,?);";
    private static final String DELETE_CUSTOMER = "DELETE FROM customer WHERE id = ? ; ";
    private static final String UPDATE_CUSTOMER = "UPDATE customer SET customer_name  = ?, surname  = ?, date_of_birth = ? WHERE id  = ?;";
    private static final String SELECT_CUSTOMER_BY_ID = "SELECT * FROM customer WHERE id = ?;";


    public List<Customer> readCustomers() {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_CUSTOMERS)
        ) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Customer customer = new Customer();
                    customer.setId(resultSet.getInt("id"));
                    customer.setName(resultSet.getString("customer_name"));
                    customer.setSurname(resultSet.getString("surname"));
                    customer.setDateOfBirth(resultSet.getString("date_of_birth"));
                    customers.add(customer);
                }
                return customers;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customers;

    }


    public List<Customer> findCustomerByNameSurname(String surname) {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_NAME_SURNAME)
        ) {

            statement.setString(1, surname);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Customer customer = new Customer();
                    customer.setId(resultSet.getInt("id"));
                    customer.setName(resultSet.getString("customer_name"));
                    customer.setSurname(resultSet.getString("surname"));
                    customer.setDateOfBirth(resultSet.getString("date_of_birth"));
                    customers.add(customer);
                }
                return customers;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customers;

    }


    public Customer create(Customer customer) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE_CUSTOMER,
                     PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1,customer.getId());
            statement.setString(2, customer.getName());
            statement.setString(3, customer.getSurname());
            statement.setString(4, customer.getDateOfBirth());
            int result = statement.executeUpdate();

            if (result != 1) {
                throw new RuntimeException("Execute update returned " + result);
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.first()) {
                    customer.setId(generatedKeys.getInt(1));
                    return customer;
                } else {
                    throw new RuntimeException("Generated key was not found");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    public void delete(Integer customerID) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMER)) {
            statement.setInt(1, customerID);
            statement.executeUpdate();

            boolean deleted = statement.execute();
            if (!deleted) {
                throw new Exception("Customer not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Customer update(Customer customer) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMER)) {
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getSurname());
            statement.setString(3, customer.getDateOfBirth());
            statement.setInt(4, customer.getId());

            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while (rs.next()) {
                customer.setId(rs.getInt(1));
            }
            return customer;
        } catch (Exception e) {
            e.printStackTrace();
        }
return customer;
    }

    public Customer findCustomerById(Integer customerID) {
        Customer customer = new Customer();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID)
        ) {

            statement.setInt(1, customerID);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    customer.setId(resultSet.getInt("id"));
                    customer.setName(resultSet.getString("customer_name"));
                    customer.setSurname(resultSet.getString("surname"));
                    customer.setDateOfBirth(resultSet.getString("date_of_birth"));

                }
                return customer;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customer;

    }


}