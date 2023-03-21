import java.io.IOException;

public interface ICommands
{

    public void add(Document doc);
    public String ToString();
    public void save(String path ) throws IOException;
    public void save() throws IOException;
    public Catalog load(String path);
    public Catalog load();


}

