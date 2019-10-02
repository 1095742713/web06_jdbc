package demo_work1;

import Tool.jdbctool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class add {
    public static void main(String[] args) throws SQLException {
        Connection connection = jdbctool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into category values (?,?,?)");
        preparedStatement.setObject(1,8);
        preparedStatement.setObject(2,"张三");
        preparedStatement.setObject(3,1000);
        int i = preparedStatement.executeUpdate();
        if(i!=0)
        {
            System.out.println("成功");
        }else{
            System.out.println("失败");
        }
        jdbctool.releaseResource(preparedStatement,connection);
    }
}
