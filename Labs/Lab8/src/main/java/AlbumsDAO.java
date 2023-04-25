import java.sql.*;

public class AlbumsDAO
{

    public void create(int artistID, String releaseYear, String title, int id) throws SQLException
    {

        Connection conn = Database.getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO albums (id, release_year, title,artistID) VALUES (?, ?, ?,? );");
        ps.setInt(1, id);
        ps.setString(2, releaseYear);
        ps.setString(3, title);
        ps.setInt(4, artistID);


        try
        {
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException e)
        {
            System.out.println("Error creating album: " + e);
        }

    }

    public Integer findByName(String name) throws SQLException
    {
        Connection conn = Database.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT id FROM albums WHERE name = ?;");
        ps.setString(1, name);

        try
        {
            return ps.executeQuery().getInt("id");
        } catch (SQLException e)
        {
            System.out.println("Error finding album: " + e);
        }

        return null;
    }

    public String findById(int id) throws SQLException
    {
        Connection conn = Database.getConnection();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select title from albums where id=" + id)) {
            return rs.next() ? rs.getString(1) : null;
        }

    }
}
