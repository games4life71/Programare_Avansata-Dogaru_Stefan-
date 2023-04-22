import java.awt.*;
import java.util.*;
import java.util.List;

import static java.lang.Thread.sleep;

/**
 * This class defines the behaviour of a robot that can move around the map and extract tokens and store them in .
 */
public class Robot implements Runnable
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

    boolean isRunning;
    Exploration explore;

    public Robot(int id, Exploration explore)
    {
        this.explore = explore;
        Random rand = new Random();
        this.robotId = id;
    }


    //make the robot pause
    public void pause()
    {
        System.out.println("Robot " + robotId + " is pausing");
        isRunning = false;
    }

    public void resume()
    {
        System.out.println("Robot " + robotId + " is resuming");
        isRunning = true;
    }

    @Override
    public void run()
    {
       // System.out.println("the initial position of the robot" + robotId +"is " + currentRow + " " + currentCol);
        try
        {
            sleep(1000);
        } catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
        // array of directions for the robot
        List<Point> directions = new ArrayList<>();
        directions.add(new Point(0, 1)); //right
        directions.add(new Point(0, -1)); //left
        directions.add(new Point(1, 0)); //down
        directions.add(new Point(-1, 0)); //up

        isRunning = true;
        Deque<Cell> stack = new ArrayDeque<>();

        stack.push(explore.getMap().getMatrix()[currentRow][currentCol]);

        while (isRunning && !stack.isEmpty())
        {

            //start by visiting the current cell
            //explore the map systematically

            Cell currentCell = stack.pop();

            if (!currentCell.isVisited())
            {
                //if the cell is not visited, visit it and add its neighbours to the stack

                explore.getMap().visit(currentCell.getRow(), currentCell.getCol(), this);
                System.out.println("Robot " + robotId + " is visiting cell " + currentCell.getRow() + " " + currentCell.getCol());


                //add the neighbours to the stack
                for (Point p : directions)
                {

                    int row = currentCell.getRow() + p.x;
                    int col = currentCell.getCol() + p.y;

                    if (row >= 0 && row < 100 && col >= 0 && col < 100)
                    {
                        if (!explore.getMap().getMatrix()[row][col].isVisited()) //if it's not visited
                            stack.push(explore.getMap().getMatrix()[row][col]);
                    }
                }

            }


        }
    }
}
