import java.util.ArrayList;
import java.util.List;

public class Exploration
{
    private final SharedMemory mem = new SharedMemory(100000);
    private final ExplorationMap map = new ExplorationMap(this.mem);
    private final List<Robot> robots = new ArrayList<>();

    public SharedMemory getMem()
    {
        return mem;
    }

    public ExplorationMap getMap()
    {
        return map;
    }

    public List<Robot> getRobots()
    {
        return robots;
    }

    public void addRobot(Robot r)
    {
        this.robots.add(r);
    }

    public Boolean isTaskComplete()
    {
        for (Cell[] row : map.getMatrix())
        {
            for (Cell c : row)
            {
                if (!c.isVisited())
                {
                    return false;
                }
            }
        }
        return true;
    }
    public void start()
    {
        for(Robot r : robots)
        {
            System.out.println("Starting robot"+ r.getRobotId());
         //start a new thread for each robot
            new Thread(r).start();
            r.isRunning = true;

        }
    }


    public void stop()
    {
        System.out.println("Stopping exploration");
        for(Robot r : robots)
        {
            System.out.println("Stopping robot"+ r.getRobotId());
            r.isRunning = false;
        }
    }
}
