package org.gfg.JBDL_64_DBConnectivity;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DBBean {

    @Bean
    public Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jbdl_64","root","root");
        return  connection;
    }

//    @Bean
//    public DataSource getDB()
//    {
//        DataSourceBuilder builder = DataSourceBuilder.create();
//        builder.url("jdbc:mysql://localhost:3306/jbdl_64");
//        builder.username("root");
//        builder.password("root");
//        return builder.build();
//    }
}
