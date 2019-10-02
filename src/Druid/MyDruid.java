package Druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class MyDruid {
    public static void main(String[] args) throws Exception {
//建立类加载器读取类文件
        InputStream is = MyDruid.class.getClassLoader().getResourceAsStream("druid.properties");
    //创建properties对象
        Properties properties = new Properties();
        properties.load(is);
        //使用工场创造dataresour对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        //通过datasourcr创造conntion
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        //关闭连接
        connection.close();
    }
}
