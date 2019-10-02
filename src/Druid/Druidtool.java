package Druid;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Druidtool {
    //声明一个datasources变量
   private static DataSource dataSource;
   //通过静态方法,在类加载时候加载类加载器
    static {
       try {
           //通过类加载器获取配置文件
           InputStream is= Druidtool.class.getClassLoader().getResourceAsStream("druid.properties");
          //创建properties对象,德鲁伊的工具只有读properties
           Properties properties = new Properties();
           //properties读取配置文件,获取连接池参数
           properties.load(is);
           //通过工厂(三方软件写好的工厂)创建datasouce
            dataSource = DruidDataSourceFactory.createDataSource(properties);
       } catch (Exception e) {
           throw new RuntimeException("加载失败");
       }
   }
   public static DataSource getdatasouce(){
        return dataSource;
   }
    // 3.提供获取连接的静态方法
    public static Connection getConnection() throws  SQLException {
        return dataSource.getConnection();
    } // 4.释放资源的静态方法（connection是归还）
    public static void releaseResource(ResultSet resultSet, Statement statement, Connection connection) {
        // 释放结果集对象
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // 释放执行对象
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // 释放连接对象
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 释放资源方法重载
    public static void releaseResource(Statement statement, Connection connection) {
        releaseResource(null, statement, connection);
    }
}


