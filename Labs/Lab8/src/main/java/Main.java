import org.apache.ibatis.jdbc.ScriptRunner;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;

public class Main
{
    public static void main(String[] args) throws SQLException, FileNotFoundException
    {
        Database.createConnection();
        Connection connection = Database.getConnection();

        //populate the database using a script
        ScriptRunner sr = new ScriptRunner(connection);
        //Creating a reader object
        Reader reader = new BufferedReader(new FileReader("D:\\Projects\\Java\\Programare_Avansata-Dogaru_Stefan-\\Labs\\Lab8\\src\\main\\scripts\\script.sql"));
        //Running the script
        sr.runScript(reader);

        ArtistDAO artistDAO = new ArtistDAO();
        artistDAO.create(1, "PinkFloyd");

        AlbumsDAO albumsDAO = new AlbumsDAO();

        albumsDAO.create(1, "1979", "The Wall", 1);
        //find by id
        System.out.println(albumsDAO.findById(1));

        //find by name
        System.out.println(artistDAO.findByName("PinkFloyd"));

        //commit the changes to the database
        connection.commit();
        Database.stopConnection();






    }

}
