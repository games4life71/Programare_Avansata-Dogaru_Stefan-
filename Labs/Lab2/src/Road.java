import java.util.Objects;

/**
 Road class that connects two locations and has a type, length, and speed limit
 @author: Dogaru Stefan Adrian
 @version: 1.0

 */
public class Road
{
    //a road connects two locations
    private RoadType type;
    private int length;
    private int speedLimit;

    private Location startLocation;
    private Location endLocation;

    /** Constructor for Road class with type included
     */
    public Road(RoadType type, int length, int speedLimit, Location startLocation, Location endLocation)
    {

        this.type = type;
        //set the length of the road to the distance between the two locations
        int min_len = (int) Math.sqrt(Math.pow(startLocation.getX() - endLocation.getX(), 2) + Math.pow(startLocation.getY() - endLocation.getY(), 2));
        if (length < min_len)
        {
            System.out.println("[ERROR] The length assigned to the road is too short ... ");
            System.exit(0);
        }

        //check if any of the location has another road connected to it
        if (startLocation.IsConnected()  && endLocation.IsConnected())
        {
            System.out.println("[ERROR] The locations already has a road connected to it ... ");
            System.exit(0);

        }

        this.speedLimit = speedLimit;
        this.startLocation = startLocation;
        this.endLocation = endLocation;

    }

//1 --> 3 --> 2 --> 4
    /** Constructor for Road class with type set to default(highway)
     */
    public Road()
    {
        this.type = RoadType.HIGHWAY;
        this.length = 0;
        this.speedLimit = 0;
    }
    public RoadType getType()
    {
        return type;
    }
    public void setType(RoadType type)
    {
        this.type = type;
    }
    public int getLength()
    {
        return length;
    }
    public void setLength(int length)
    {
        this.length = length;
    }
    public int getSpeedLimit()
    {
        return speedLimit;
    }
    public void setSpeedLimit(int speedLimit)
    {
        this.speedLimit = speedLimit;
    }

    @Override
    public String toString()
    {
        return "Road{" +
                "type=" + type +
                ", length=" + length +
                ", speedLimit=" + speedLimit +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true; //case when the object is compared to itself
        if (o == null || getClass() != o.getClass()) return false; //case when the object is compared to null or to an object of a different class
        Road road = (Road) o;

        return length == road.length && speedLimit == road.speedLimit && type == road.type;

    }

    @Override
    public int hashCode()
    {
        return Objects.hash(type, length, speedLimit);
    }
}
