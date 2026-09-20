package healthfirstpims;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/healthfirst_pims";

    private static final String USER = "root";

    private static final String PASSWORD = "#Tupaceazye18";

    public static Connection getConnection() {

        try {

            Connection connection =
                    DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Database connected successfully!");

            return connection;

        } catch (SQLException e) {

            System.out.println("Database connection failed!");
            System.out.println(e.getMessage());

            return null;
        }
    }

    public static void main(String[] args) {

        Connection connection = getConnection();

        if (connection != null) {

            try {
                connection.close();
                System.out.println("Connection test completed.");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }
    }
}