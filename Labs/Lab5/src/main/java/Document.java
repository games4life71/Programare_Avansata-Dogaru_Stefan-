import java.io.Serializable;

/**
 * This class defines the behavior of a document
 */
public class Document implements Serializable
{

    protected String id;
    protected String Name;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return Name;
    }

    public void setName(String name)
    {
        Name = name;
    }

    protected  String ToString()
   {
       StringBuilder sb = new StringBuilder();
       sb.append("ID: " + id + " Name: " + Name);
       return  sb.toString();

   }
    public Document(String id, String Name)
    {
        this.id = id;
        this.Name = Name;
    }
    public Document()
    {
        this.id = "0";
        this.Name = "NoName";
    }

}
