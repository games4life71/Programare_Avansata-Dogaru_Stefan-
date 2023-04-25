import java.sql.*;

public class ArtistDAO
{
    public void create(int id, String name ) throws SQLException
    {
        Connection conn = Database.getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO artist (id, name) VALUES (?, ?);");
        ps.setInt(1, id);
        ps.setString(2, name);
        try
        {
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException e)
        {
            System.out.println("Error creating artist: " + e);
        }
    }

    public String findByName(String name) throws SQLException
    {
        Connection conn = Database.getConnection();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id  from artist where name=" + "'" + name  +"'")) {
            return rs.next() ? rs.getString(1) : null;
        }

    }
}
