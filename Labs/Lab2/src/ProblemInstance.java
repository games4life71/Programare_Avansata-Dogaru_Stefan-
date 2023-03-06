import java.util.LinkedList;
import java.util.Queue;

/**
 * A class that represents a problem instance for the shortest path problem.
 */
public class ProblemInstance
{

    //locations of the problem
    private Location[] locations;
    private Road[] roads;
    private int maxRoads;
    private int currentRoads = 0;
    private Location startLocation;
    private Location endLocation;
    private int[][] adjacencyMatrix = new int[10][10];


    public void setStartLocation(Location startLocation)
    {
        this.startLocation = startLocation;
    }

    public Location getStartLocation()
    {
        return startLocation;
    }

    public void setEndLocation(Location endLocation)
    {
        this.endLocation = endLocation;
    }

    public Location getEndLocation()
    {
        return endLocation;
    }


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

        }

        //check if the roads are valid
        for (Road road : roads)
        {

        }

        return true;
    }

    /**
     * @param road      road that will be added to the problem instance
     * @param location1 location that is connected to the road
     * @param location2 location that is connected to the road
     * @return True if the road was added successfully, False otherwise (if the number of roads is equal to the number of locations - 1)
     */
    public boolean AddRoad(Road road, Location location1, Location location2)
    {
        if (currentRoads == maxRoads)
        {
            System.out.println("[ERROR] Cannot add more roads ... ");
            return false;
        }

        this.roads[currentRoads++] = road;

        //set the connected road for the locations

        //complete the adjacency matrix
        this.adjacencyMatrix[this.getLocation(location1).getId()][this.getLocation(location2).getId()] = 1;
        this.adjacencyMatrix[this.getLocation(location2).getId()][this.getLocation(location1).getId()] = 1;

        this.getLocation(location1).setConnectedRoad(road);
        this.getLocation(location2).setConnectedRoad(road);

        return true;
    }

    public void printAdjacencyMatrix()
    {
        for (int i = 0; i < this.locations.length; i++)
        {
            for (int j = 0; j < this.locations.length; j++)
            {
                System.out.print(this.adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * @return True if the end location is reachable from the start location, False otherwise
     */
    public boolean isReachable()
    {
        if (this.startLocation == null || this.endLocation == null)
        {
            System.out.println("[ERROR] Start or end location is not set ... ");
            return false;
        }

        //check if the start location is connected to the end location
        if (this.adjacencyMatrix[this.startLocation.getId()][this.endLocation.getId()] == 1)
            return true;

        //BFS algorithm
        Queue<Location> queue = new LinkedList<>();
        boolean[] visited = new boolean[this.locations.length];

        queue.add(this.startLocation);

        visited[this.startLocation.getId()] = true;

        while (!queue.isEmpty())
        {
            Location currentLocation = queue.poll(); //returns null if the queue is empty
            for (int i = 0; i < this.locations.length; i++)
            {
                if (this.adjacencyMatrix[currentLocation.getId()][i] == 1 && !visited[i])
                {
                    //if we reach the end location, return true
                    queue.add(this.getLocation(this.locations[i]));
                    visited[i] = true;

                    if (i == this.endLocation.getId())
                        return true;

                }
            }
        }
        return false;


    }

}
