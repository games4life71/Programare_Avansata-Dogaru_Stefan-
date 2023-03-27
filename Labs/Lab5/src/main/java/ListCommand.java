public class ListCommand extends Command
{
    private Catalog catalog;

    /**
     * Constructor
     *
     * @param catalog catalog to list
     */
    public ListCommand(Catalog catalog)
    {
        this.catalog = catalog;
    }

    @Override
    public String CommandName()
    {
        return "list";
    }

    @Override
    public void execute()
    {
        //iterate through the documents in the catalog and print them
        for(Document doc : this.catalog.getDocuments())
        {
            System.out.println(doc.toString());
        }
    }
}
