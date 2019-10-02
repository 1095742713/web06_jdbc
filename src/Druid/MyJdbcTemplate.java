package Druid;

import java.sql.*;

public class MyJdbcTemplate {
    public static void main(String[] args) throws SQLException {
        //获取驱动,以及连接
        Connection connection = Druidtool.getConnection();
        //编写sql语句
        String c="insert into category values (?,?,?)";
        //获取预编译对象编译sql语句
        PreparedStatement preparedStatement = connection.prepareStatement(c);
        //通过preparedStatement,获取 parametermetadata 对象
        ParameterMetaData parameterMetaData = preparedStatement.getParameterMetaData();
        //通过paramemetadata中的getparametercont获取sql语句中?的个数
        int parameterCount = parameterMetaData.getParameterCount();
        System.out.println("有几个?"+parameterCount);
    }
}
