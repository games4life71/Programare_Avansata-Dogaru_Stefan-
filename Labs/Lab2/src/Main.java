public class Main
{
    public static void main(String[] args)
    {

        // -----COMPULSATORY PART ----------

                Airport  airport1 = new Airport();

                airport1.setGates(12);
                airport1.setTerminals(2);

                Airport airport2 = new Airport();
                Location location1 = new Location(12,13);
                Location location2 = new Location(122,12);
                double min_distance = Location.getMinDistance(location1,location2);

                Road road1 = new Road(RoadType.HIGHWAY ,(int)min_distance+10,100,location1,location2);
                road1.setLength(12);

        System.out.println(road1.toString());
        System.out.println(location1.toString());
        System.out.println(location2.toString());

        location1.setConnectedRoad(road1);
        location2.setConnectedRoad(road1);





        //       ----------HOMEWORK PART --------------

//        /**
//         * 1. Create 10 locations with random x and y coordinates
//         */
//        Location[] locations = new Location[10]; //arrray to store locations
//
//        /**
//         * 2. Create 9 roads between each location
//         */
//        Road[] roads = new Road[9]; //array to store roads
//
//        //initialize the locations
//        /**
//         * 3. Initialize the locations and also check for duplicate locations
//         */
//
//        for (int i = 0; i < locations.length; i++)
//        {
//            //TODO check if the location is already declared or not
//
//            //generate random x and y coordinates
//            int ran_x = (int) (Math.random() * 100);
//            int ran_y = (int) (Math.random() * 100);
//
//            locations[i] = new Location(ran_x, ran_y);
//            locations[i].setLocationType(new Airport()); // all will be airports
//
//
//            //check if the location is already declared
//            for (int j = 0; j < i; j++)
//            {
//                if (locations[i].equals(locations[j]))
//                {
//                    System.out.println("[ERROR] The exact SAME location is already declared ... ");
//                    return;
//                }
//            }
//        }
//
//        //create a problem instance
//        ProblemInstance problemInstance = new ProblemInstance(locations);
//        //create some roads
//        Road road1 = new Road(RoadType.HIGHWAY, (int) Location.getMinDistance(locations[0], locations[1]), 100, locations[0], locations[1]);
//
//        problemInstance.AddRoad(road1,locations[0],locations[1]);





    }
}


