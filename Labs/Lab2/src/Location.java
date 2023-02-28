import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * A class that represents a location in a 2D plane.
 * Each location has an x and y coordinate, and a type specified in LocationType enum.
 * The type can be either a city or a road.
 * The default type is city.
 *
 * @author Dogaru Stefan Adrian
 *
 *
 *
 */
public class Location
{
    private int x;
    private int y;
    private LocationType type;

    private Road roads[] = new Road[2];  //assume we can only connect 1 road between 2 locations




/** Constructor for Location class with type included

 */
    public Location(int x, int y)
    {

        this.x = x;
        this.y = y;
        this.type = null; //default type is null

    }
    //setter for LocationType
    public void setLocationType(LocationType type)
    {
        this.type = type;
    }

    public LocationType getLocationType()
    {
        return this.type;
    }



    public LocationType getType()
    {
        return type;
    }

    public void setType(@NotNull LocationType type)
    {
        this.type = type;
    }

    /** Constructor for Location class with type set to default

     */


    /**getter and setter methods for x and y coordinates

     */
    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public void setLocation(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public Road[] getRoads()
    {
        return roads;
    }

    public void setRoads(Road[] roads)
    {
        this.roads = roads;
    }

    /*
    Translates the location by dx along the x-axis and dy along the y-axis
     */


    public static  double getMinDistance(@NotNull Location loc1, @NotNull Location loc2)
    {
        return Math.sqrt(Math.pow(loc1.getX() - loc2.getX(), 2) + Math.pow(loc1.getY() - loc2.getY(), 2));
    }



    @Override
    public String toString()
    {
        return "(" + this.x + ", " + this.y + ")";
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true; //cant compare to itself

        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;
        return x == location.x && y == location.y;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(x, y);
    }

    public void setConnectedRoad(Road road)
    {
        if(this.roads[0] == null)
            this.roads[0] = road;
        else if(this.roads[1] == null)
            this.roads[1] = road;
        else
        {
            System.out.println("[ERROR] The location already has 2 roads connected to it ... ");
            System.exit(0);
        }
    }

    public boolean IsConnected()
    {
        if(this.roads[0] == null && this.roads[1] == null)
            return false;
        else
            return true;
    }

}
