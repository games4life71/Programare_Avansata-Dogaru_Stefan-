import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class SaveCommand extends Command
{
    private Catalog catalog;  // the catalog to be saved

    public SaveCommand(Catalog catalog)
    {
        this.catalog = catalog;
    }

    @Override
    public String CommandName()
    {
        return "save";
    }


    @Override
    public void execute() throws IOException
    {

        ObjectMapper mapper = new ObjectMapper();
        try
        {
            mapper.writeValue(new File("D:\\Projects\\Java\\Programare_Avansata-Dogaru_Stefan-\\Labs\\Lab5\\target\\assets\\catalog.json"), this.catalog.getDocuments());
        } catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println("[DEBUG] Catalog saved to default path");

    }

    public void execute(String path) throws IOException
    {
        //open a file and write the catalog to it

        ObjectMapper mapper = new ObjectMapper();
        try
        {
            mapper.writeValue(new File(path + "\\" + "catalog.json"), this.catalog.getDocuments());
        } catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println("[DEBUG]Catalog saved to " + path);


    }
}
