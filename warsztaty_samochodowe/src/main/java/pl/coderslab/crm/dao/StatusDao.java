package pl.coderslab.crm.dao;

import pl.coderslab.crm.model.Employee;
import pl.coderslab.crm.model.Order;
import pl.coderslab.crm.model.Status;
import pl.coderslab.crm.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StatusDao {

    private static final String SELECT_STATUS_BY_ID = "SELECT description FROM status WHERE id = ?; ";


    public Status selectById(int statusId) {

        Status status = new Status();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_STATUS_BY_ID)
        ) {
            statement.setInt(1, statusId);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    status.setId(resultSet.getInt("id"));
                    status.setStatus(resultSet.getString("description"));

                }
                return status;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;

    }
}
