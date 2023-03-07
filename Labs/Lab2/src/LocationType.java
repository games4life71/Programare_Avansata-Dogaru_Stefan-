/**
 * Abstract class LocationType that defines basic information about LocationTypes
 */
public abstract  class  LocationType
{

    protected String locationType;
    protected int population;
    protected  LocationType()
    {

    }

    /**
     * Setter for locationType
     * @param locationType  string
     */
    protected  void setLocationType(String locationType)
    {
        this.locationType = locationType;
    }

    /**
     * Set the population
     * @param population int
     */
    protected  void setPopulation(int population)
    {
        this.population = population;
    }

    /**
     *  Getter for location type
     * @return locationType
     */
    protected  String getLocationType()
    {
        return this.locationType;
    }

    protected  int getPopulation()
    {
        return this.population;
    }



}

