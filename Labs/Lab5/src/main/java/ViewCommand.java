import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Class that defines the behaviour of a ViewCommand that opens a document using the native operating system application
 */
public class ViewCommand extends Command
{
    private Document doc;  // the catalog to be viewed

    public ViewCommand(Document doc)
    {
        this.doc = doc;
    }

    @Override
    public String CommandName()
    {
        return "view";
    }

    @Override
    public void execute() throws IOException
    {

        String doc_path = doc.getPath();
        Desktop desktop = Desktop.getDesktop();
        try
        {
            // if the document is a URL, open it in the default browser
            if (doc.isURL)
            {
                desktop.browse(new java.net.URI(doc_path));
            } else // otherwise, open it using the native operating system application
                desktop.open(new java.io.File(doc_path));
        } catch (IOException e)
        {
            e.printStackTrace();

        } catch (URISyntaxException e)
        {
            e.printStackTrace();
        }
    }
}
