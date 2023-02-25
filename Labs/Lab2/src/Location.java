import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * A class that represents a location in a 2D plane.
 * Each location has an x and y coordinate, and a type specified in LocationType enum.
 * The type can be either a city or a road.
 * The default type is city.
 *
 * @author Dogaru Stefan Adrian
 * @version 1.0
 *
 *
 */
public class Location
{
    private int x;
    private int y;
    private LocationType type;

    private Road road;

    private Road connectedRoad; //assume we can only connect 1 road between 2 locations


/** Constructor for Location class with type included

 */
    public Location(int x, int y, @NotNull LocationType type)
    {
        this.x = x;
        this.y = y;
        this.type = type;
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
    public Location(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.type = LocationType.CITY; //default is city type
    }

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

    /*
    Translates the location by dx along the x-axis and dy along the y-axis
     */
    public void translate(int dx, int dy)
    {
        this.x += dx;
        this.y += dy;
    }

    public static  double distance(@NotNull Location loc1, @NotNull Location loc2)
    {
        return Math.sqrt(Math.pow(loc1.x - loc2.x, 2) + Math.pow(loc1.y - loc2.y, 2));
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
        this.connectedRoad = road;
    }

    public boolean IsConnected()
    {
          if(this.connectedRoad != null)
                return true;
          else return false;

    }

}
