package modelo.persistencia.JDBC;

import java.sql.*;

/**
 *
 * @author Rafa
 */
public class Persistencia {

    // XAMPP
    private static String url = "jdbc:mysql://localhost:3306/football?autoReconnect=true&useSSL=false";
    private static String login = "root";
    private static String password = "";

    private static Connection conexion = null;

    /**
     * La apertura de la conexión es implementada según el patrón singleton de
     * esta forma, a lo sumo, tendremos una sola conexión abierta en la
     * aplicación
     */
    public static Connection createConnection() {
        if (conexion == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                conexion = DriverManager.getConnection(url, login, password);
            } catch (ClassNotFoundException e) {
                System.out.println(e);
            } catch (SQLException e) {
                System.out.println(e);
            } catch (java.lang.InstantiationException e) {
                System.out.println(e);
            } catch (java.lang.IllegalAccessException e) {
                System.out.println(e);
            }
        }
        return conexion;
    }

    public static void closeConnection() {
        try {
            if (conexion != null) {
                conexion.close();
                conexion = null;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}
