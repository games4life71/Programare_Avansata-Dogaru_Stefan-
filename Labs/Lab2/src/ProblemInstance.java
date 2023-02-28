/**
 * A class that represents a problem instance for the shortest path problem.
 */
public class ProblemInstance
{


    //locations of the problem
    private Location[] locations;
    private Road[] roads ;
    private int maxRoads;
    private int currentRoads = 0;
    private Location startLocation;
    private Location endLocation;




    //constructor for ProblemInstance class
    public ProblemInstance(Location[] locations)
    {
        this.locations = locations;
        this.maxRoads = locations.length - 1;
        this.roads = new Road[maxRoads];
    }
    //fiinds and returns a  specific location from the locations array
    public Location getLocation(Location location)
    {
        for (Location loc : locations)
        {
            if (loc.equals(location))
            {
                return loc;
            }
        }
        return null;
    }


    public boolean isValid()
    {
        //check if the locations are valid
        for (Location location : locations)
        {
            //check if the location is connected to minimum a road
            if (!location.IsConnected())
            {
                System.out.println("[ERROR] The location " + location + " is not connected to a road ... ");
                return false;

            }
        }

        //check if the roads are valid
        for (Road road : roads)
        {

        }

        return true;
    }

    /**
     *
     * @param road road that will be added to the problem instance
     * @param location1 location that is connected to the road
     * @param location2 location that is connected to the road
     * @return True if the road was added successfully, False otherwise (if the number of roads is equal to the number of locations - 1)
     */
    public boolean AddRoad(Road road,Location location1, Location location2)
    {
        if (currentRoads == maxRoads)
        {
            System.out.println("[ERROR] Cannot add more roads ... ");
            return false;
        }

        this.roads[currentRoads++] = road;
        //set the connected road for the locations

        this.getLocation(location1).setConnectedRoad(road);
        this.getLocation(location2).setConnectedRoad(road);
        return  true;
    }


}
