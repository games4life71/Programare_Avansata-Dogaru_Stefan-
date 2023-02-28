public final class Airport extends LocationType
{

    private int Terminals;
    private int Gates;
    private int Runways;

    public int getGates()
    {
        return Gates;
    }

    public void setGates(int gates)
    {
        Gates = gates;
    }

    public int getRunways()
    {
        return Runways;
    }

    public void setRunways(int runways)
    {
        Runways = runways;
    }

    public int getTerminals()
    {
        return Terminals;
    }

    public void setTerminals(int terminals)
    {
        Terminals = terminals;
    }

    public Airport()
    {
        super();
    }


}
