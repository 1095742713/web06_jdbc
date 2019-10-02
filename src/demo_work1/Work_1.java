package demo_work1;

import Tool.jdbctool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Work_1 {
    public static void main(String[] args) throws SQLException {
        Connection connection = jdbctool.getConnection();
        Statement statement = connection.createStatement();
        String c="select * from category  ";
        ResultSet resultSet = statement.executeQuery(c);
        while (resultSet.next()){
            System.out.println(1);
        }
        jdbctool.releaseResource(resultSet,statement,connection);
    }
}
