package demo_work1;

import Druid.Druidtool;
import Tool.jdbctool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class mydelete {
    public static void main(String[] args) throws SQLException {
        Connection connection = Druidtool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("delete from category where cid=?");
        preparedStatement.setObject(1,2);
        int i = preparedStatement.executeUpdate();
        if(i!=0){
            System.out.println("删除成功");
        }else{
            System.out.println("不存在");
        }

        jdbctool.releaseResource(preparedStatement,connection);

    }
}
