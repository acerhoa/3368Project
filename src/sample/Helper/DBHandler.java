package sample.Helper;

import sample.Model.Staff;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBHandler extends DBConfig {
    Connection dbConnection;

    public Connection getDbConnection() throws SQLException, ClassNotFoundException {
        String connectionString = "jdbc:mysql://" + dbHost + "/" + dbName;
        Class.forName("com.mysql.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString,dbUser,dbPass);
        return dbConnection;
    }
    public void addStaff(Staff staff){
        String insert = "INSERT INTO " + DBConstant.STAFF_TABLE + "(" +
                DBConstant.STAFF_FIRSTNAME + "," +
                DBConstant.STAFF_LASTNAME + "," +
                DBConstant.STAFF_USERNAME + "," +
                DBConstant.STAFF_PASSWORD + "," +
                DBConstant.STAFF_PHONE  + ")" +
                "VALUES(?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setString(1,staff.getFirstname());
            preparedStatement.setString(2,staff.getLastname());
            preparedStatement.setString(3,staff.getUsername());
            preparedStatement.setString(4,staff.getPassword());
            preparedStatement.setString(5,staff.getPhone());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
