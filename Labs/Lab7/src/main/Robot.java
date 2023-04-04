import java.util.Random;

/**
 * This class defines the behaviour of a robot that can move around the map and extract tokens and store them in .
 */
public class Robot implements  Runnable
{


    private final int robotId;

    public int getRobotId()
    {
        return robotId;
    }
    public int currentRow;
    public int currentCol;

    public int getCurrentRow()
    {
        return currentRow;
    }

    public void setCurrentRow(int currentRow)
    {
        this.currentRow = currentRow;
    }

    public int getCurrentCol()
    {
        return currentCol;
    }

    public void setCurrentCol(int currentCol)
    {
        this.currentCol = currentCol;
    }

    boolean isRunning ;
    Exploration explore;

    public Robot(int id , Exploration explore )
    {
        this.explore = explore;
        Random rand = new Random();

        this.currentCol =rand.nextInt(0,99);
        this.currentRow =rand.nextInt(0,99);
        this.robotId = id;
    }
//    public Boolean checkIfDone()
//    {
//        for(Cell c : explore.getMap().matrix)
//        {
//            if(!c.isVisited())
//            {
//                return false;
//            }
//        }
//    }
   @Override
    public void run()
    {
        while(isRunning)
        {

            //move to the next cell randomly
            //pick a random direction
            Random rand = new Random();
            int direction = rand.nextInt(0,3);
            switch (direction)
            {
                case 0:
                    //move up
                    if(currentRow > 0)
                    {
                        currentRow--;
                    }
                    break;
                case 1:
                    //move down
                    if(currentRow < 99)
                    {
                        currentRow++;
                    }
                    break;
                case 2:
                    //move left
                    if(currentCol > 0)
                    {
                        currentCol--;
                    }
                    break;
                case 3:
                    //move right
                    if(currentCol < 99)
                    {
                        currentCol++;
                    }
                    break;
            }
            System.out.println("Robot "+ robotId + " is moving to cell ("+ currentRow + "," + currentCol + ")");
            //pick a new cell to explore
            explore.getMap().visit(currentRow,currentRow,this);
            //sleep for 1 second
            try
            {
                Thread.sleep(2);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
