public abstract  class  LocationType
{

    protected String locationType;
    protected int population;
    protected  LocationType()
    {

    }

    protected  void setLocationType(String locationType)
    {
        this.locationType = locationType;
    }

    protected  void setPopulation(int population)
    {
        this.population = population;
    }

    protected  String getLocationType()
    {
        return this.locationType;
    }

    protected  int getPopulation()
    {
        return this.population;
    }



}

