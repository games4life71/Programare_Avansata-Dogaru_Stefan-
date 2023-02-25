public class Main
{
    public static void main(String[] args)
    {
        Location location1 = new Location(1, 2, LocationType.CITY);
        Location location2 = new Location(3, 4, LocationType.AIRPORT);

        //compute the minimum length that a road can have
        double distance = Location.distance(location1, location2);

        Road road1 = new Road(RoadType.HIGHWAY, (int)(distance + 4), 60, location1, location2);
        //connect the road to the location

        location1.setConnectedRoad(road1);
        location2.setConnectedRoad(road1);

        Road road2 = new Road(RoadType.HIGHWAY, (int)(distance+3), 60, location2, location1);

        //TODO does the location has to know the road it is on???


    }
}


