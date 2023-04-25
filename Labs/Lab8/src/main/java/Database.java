import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database
{
    private static final String URL =
            "jdbc:postgresql://localhost:5432/music";
    private static final String USER = "postgres";
    private static final String PASSWORD = "root";
    private static Connection connection = null;

    Database() {}

    public static Connection getConnection() throws SQLException
    {

        return connection;
    }

    public static void createConnection() throws SQLException
    {

        try
        {
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to database");
        }
        catch (SQLException e)
        {
            System.out.println("Error creating connection to database: " + e);
            System.exit(-1);
        }
    }

    public static  void stopConnection() throws SQLException
    {
        connection.close();
    }



}
