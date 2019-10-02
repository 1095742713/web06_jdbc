package c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


public class myc3po {
    public static void main(String[] args) throws SQLException {
       DataSource dataSources = new ComboPooledDataSource();
        Connection connection = dataSources.getConnection();
        for (int i = 1; i < 11; i++) {
            connection = dataSources.getConnection();
            System.out.println(connection+".."+i);
        }

        connection.close();
    }
}
