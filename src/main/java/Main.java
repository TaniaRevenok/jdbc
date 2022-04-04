import ua.goit.config.DatabaseManagerConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;


public class Main {
    public static void main(String[] args) throws SQLException {


        DatabaseManagerConnector dbConnector = new DatabaseManagerConnector("localhost", 5432, "practise", "postgres", "12345");
        Connection connection = dbConnector.getConnection();

    }

}
