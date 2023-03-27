import java.util.Set;

public class AddCommand extends Command
{
    private Catalog catalog;
    private Document doc;

    /**
     * Constructor
     * @param catalog catalog to add to
     * @param document document to add to catalog
     */
    public AddCommand(Catalog catalog, Document document)
    {
        this.catalog = catalog;
        this.doc = document;
    }

    @Override
    public String CommandName()
    {
        return "add";
    }

    @Override
    public void execute()
    {
       // check if the id is unique
        try
        {
            //check if the id is unique
            for (Document document : catalog.getDocuments())
            {
                if (document.getId().equals(doc.getId()))
                {
                    //throw new Exception("[ERROR] Document already exists");
                }

            }
                //add the document to the catalog

                Set<Document> documents = catalog.getDocuments();
                documents.add(doc);
                catalog.setDocuments(documents);


        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}

