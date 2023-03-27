import java.io.Serializable;

/**
 * This class defines the behavior of a document
 */
public class Document implements Serializable
{

    protected String id;
    protected String Name;
    protected  String extension;
    protected  String path;
    protected  Boolean isURL = false;


    public Document(String id, String Name,String path,Boolean isURL,String extension,String author)
    {
        super();
        this.id = id;
        this.extension = extension;
        this.path = path;
        this.Name = Name;
        this.isURL = isURL;
    }

//    public Document()
//    {
//        this.id = "0";
//        this.Name = "NoName";
//        this.extension = "NoExtension";
//        this.path = "NoPath";
//        this.isURL = false;
//
//    }
    public Document()
    {

    }

    public Boolean getisURL()
    {
        return isURL;
    }

    public void setisURL(Boolean URL)
    {
        isURL = URL;
    }

    public String getPath()
    {
        return path;
    }

    public void setPath(String path)
    {
        this.path = path;
    }

    public String getExtension()
    {
        return extension;
    }

    public void setExtension(String extension)
    {
        this.extension = extension;
    }

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

    @Override
    public  String toString()
   {
       System.out.printf("ID: %s Name: %s",id,Name);
       StringBuilder sb = new StringBuilder();
       sb.append("ID: " + id + " Name: " + Name + " Path: " + path + " Extension: " + extension + " isURL: " + isURL    );
       return  sb.toString();
   }


}
