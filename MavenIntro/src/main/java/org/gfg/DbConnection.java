package org.gfg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jbdl_64","root", "root");
        con.createStatement().execute("CREATE TABLE JBDL(NAME VARCHAR(40),ID INT)");
    }
}
