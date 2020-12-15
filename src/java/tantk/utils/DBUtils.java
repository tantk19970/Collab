/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tantk.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Poca
 */
public class DBUtils {
        private final static String connString ="jdbc:sqlserver://localhost:1433;databaseName=Collab";
    private final static String dbuser="sa";
    private final static String dbpass="TheChosenOne";
    private final static String forName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(forName);
        Connection con = DriverManager.getConnection(connString, dbuser,dbpass);
        return con;
    }
    
}
