package edu.siglo21.app.Model;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

public class conexionFabrica {

    public static final String URL = "jdbc:mysql://localhost:3306/seminario";
    public static final String USER = "seminario";
    public static final String PASS = "Abc1234$";

    public static Connection getConexion (){
        try{
            DriverManager.registerDriver(new Driver() {
                @Override
                public Connection connect(String url, Properties info) throws SQLException {
                    return null;
                }

                @Override
                public boolean acceptsURL(String url) throws SQLException {
                    return false;
                }

                @Override
                public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
                    return new DriverPropertyInfo[0];
                }

                @Override
                public int getMajorVersion() {
                    return 0;
                }

                @Override
                public int getMinorVersion() {
                    return 0;
                }

                @Override
                public boolean jdbcCompliant() {
                    return false;
                }

                @Override
                public Logger getParentLogger() throws SQLFeatureNotSupportedException {
                    return null;
                }
            });
            return DriverManager.getConnection(URL,USER,PASS);
        } catch (SQLException ex){
            throw new RuntimeException("Error conectandose a la base de datos.",ex);
        }

    }
}
