package demo_work1;

import Tool.jdbctool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class work2 {
    public static void main(String[] args) throws SQLException {
        // 1. 通过scanner模拟用户名和密码录入
        System.out.println("欢迎来到德莱联盟...");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = scanner.nextLine();
        System.out.println("请输入密码：");
        String password = scanner.nextLine();
        // 2. 根据用户名和密码操作JDBC查询数据库
        // 2.1 获取连接
        Connection connection = jdbctool.getConnection();
        //创建运行对象
        PreparedStatement preparedStatement = connection.prepareStatement("select *from category where cid=? and cname =?");
        //获取统配的值
        preparedStatement.setObject(1,username);
        preparedStatement.setObject(2,password);

        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            System.out.println("成功");
        }else{
            System.out.println("失败");
        }
        jdbctool.releaseResource(resultSet,preparedStatement,connection);

    }
}
