import ua.config.PostgresHikariProvider;

import java.sql.Connection;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {


        PostgresHikariProvider dbConnector = new PostgresHikariProvider("localhost", 5432, "practise", "postgres", "12345");
        Connection connection = dbConnector.getConnection();

    }

}
