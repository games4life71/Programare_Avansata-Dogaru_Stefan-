/**
 * This class will be used to keep track of the time
 */
public class TheGreatTimeKeeper implements Runnable
{

    private int limit; // in seconds
    private Exploration explore;

    private int timeElapsed = 0;

    public TheGreatTimeKeeper(Exploration explore)
    {
        this.limit = 1000;
        this.explore = explore;
    }

    public TheGreatTimeKeeper(int limit, Exploration explore)
    {
        this.limit = limit;
        this.explore = explore;
    }

    {
        this.limit = limit;
    }


    @Override
    public void run()
    {
        //start the timer
        while (timeElapsed < limit)
        {
            try
            {
                Thread.sleep(1000);
                timeElapsed++;
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }


        if (timeElapsed == limit)
        {
            System.out.println("Time is up ... stopping exploration");
            //stop the other robots from running
            for (Robot r : explore.getRobots())
            {
                r.pause();
            }
        }
    }


}
