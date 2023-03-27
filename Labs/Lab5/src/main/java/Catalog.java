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
public class Catalog implements Serializable
{
    private Set<Document> documents = new HashSet<>();
    private String id;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

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
    @Override
    public String toString()
    {
        return "Catalog{" + "documents=" + documents + '}';
    }


}