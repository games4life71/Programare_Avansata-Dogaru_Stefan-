import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.CompactStringObjectMap;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * This class defines the behavior of a catalog that manaeges different docuements
 */
public class Catalog implements ICommands, Serializable
{
    private Set<Document> documents = new HashSet<>();

    public Catalog()
    {

    }

    public Catalog(Set<Document> documents)
    {
        this.documents = documents;
    }

    public Set<Document> getDocuments()
    {
        return documents;
    }

    public void setDocuments(Set<Document> documents)
    {
        this.documents = documents;
    }

    /**
     * Adds a document with an unique id to the catalog
     *
     * @param doc Document
     */
    @Override
    public void add(Document doc)
    {
        //check if the id is unique
        try
        {
            //check if the id is unique
            for (Document document : documents)
            {
                if (document.getId().equals(doc.getId()))
                {
                    throw new Exception("[ERROR] Document already exists");
                }

            }

            documents.add(doc);

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String ToString()
    {
        return null;
    }

    @Override
    public String toString()
    {
        return "Catalog{" + "documents=" + documents + '}';
    }

    /**
     * Saves the catalog to a file --> default path is ../target/assets/catalog.json
     */
    public void save() throws IOException
    {
        //open a file and write the catalog to it

        ObjectMapper mapper = new ObjectMapper();
        try
        {
            mapper.writeValue(new File("D:\\Projects\\Java\\Programare_Avansata-Dogaru_Stefan-\\Labs\\Lab5\\target\\assets\\catalog.json"), documents);
        } catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println("[DEBUG] Catalog saved to default path");

    }

    /**
     * Saves the catalog to a custom path
     *
     * @param path path to be saved
     * @throws IOException
     */
    @Override
    public void save(String path) throws IOException
    {
        //open a file and write the catalog to it

        //open a file and write the catalog to it

        ObjectMapper mapper = new ObjectMapper();
        try
        {
            mapper.writeValue(new File(path + "\\" + "catalog.json"), documents);
        } catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println("[DEBUG]Catalog saved to " + path);

    }


    /**
     * Loads a catalog from a file
     *
     * @param path path to the file
     */
    @Override
    public Catalog load(String path)
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
        return catalog;
    }

    /**
     * Loads a catalog from a file --> default path is ../target/assets/catalog.json
     */
    @Override
    public Catalog load()
    {
        System.out.println("[DEBUG] Loading catalog from default path...");
        //open a file and read the catalog from it
        ObjectMapper mapper = new ObjectMapper();
        Catalog catalog = new Catalog();
        try
        {
            HashSet<Document> documents = mapper.readValue(new File("D:\\Projects\\Java\\Programare_Avansata-Dogaru_Stefan-\\Labs\\Lab5\\target\\assets\\catalog.json"), HashSet.class);
            catalog.setDocuments(documents);

            // System.out.println(catalog.ToString());
        } catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        return catalog;
    }
}