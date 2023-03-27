import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;

public class LoadCommand extends Command
{
    private Catalog catalog;  // the catalog to be loaded

    public LoadCommand(Catalog catalog)
    {
        this.catalog = catalog;
    }

    @Override
    public String CommandName()
    {
        return "load";
    }

    /**
     * Load the catalog from the default path
     *
     * @throws IOException
     */

    public void execute(String path) throws IOException
    {
        System.out.println("[DEBUG] Loading catalog from " + path);
        //open a file and read the catalog from it
        ObjectMapper mapper = new ObjectMapper();
        Catalog catalog = new Catalog();

        try
        {
            //catalog = new Catalog( mapper.readValue(new File(path), Catalog.class));
            HashSet<Document> documents = mapper.readValue(new File(path), HashSet.class);
            catalog.setDocuments(documents);
            //System.out.println(catalog.ToString());
        } catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        this.catalog = catalog;

    }

    @Override
    public void execute() throws IOException
    {

        System.out.println("[DEBUG] Loading catalog from default path...");
        //open a file and read the catalog from it
        ObjectMapper mapper = new ObjectMapper();

       // Catalog catalog_read = new Catalog();
        try
        {
            HashSet<Document> documents = mapper.readValue(new File("D:\\Projects\\Java\\Programare_Avansata-Dogaru_Stefan-\\Labs\\Lab5\\target\\assets\\catalog.json"), new TypeReference<HashSet<Document>>(){});
            catalog.setDocuments(documents);

        } catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Returns the catalog loaded by the execute command
     */

}
