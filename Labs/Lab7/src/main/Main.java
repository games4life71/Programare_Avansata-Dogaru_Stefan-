import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Main
{
    public static void main(String[] args) throws InterruptedException
    {

        Exploration explore = new Exploration();
        TheGreatTimeKeeper timeKeeper = new TheGreatTimeKeeper(1000,explore);
        new Thread(timeKeeper).start();


        Random rand = new Random();


        Robot r1 = new Robot(1,explore);
        r1.currentCol = rand.nextInt(0,99);
        r1.currentRow = rand.nextInt(0,99);

        explore.addRobot(r1);

        Robot r2 = new Robot(2,explore);
        //make sure the robots are not in the same cell
//        while(r2.currentCol == r1.currentCol && r2.currentRow == r1.currentRow)
//        {
//            r2.currentCol = rand.nextInt(0,99);
//            r2.currentRow = rand.nextInt(0,99);
//        }
        r2.currentCol = rand.nextInt(0,99);
        r2.currentRow = rand.nextInt(0,99);

       explore.addRobot(r2);


        Robot r3 = new Robot(3,explore);
        //make sure the robots are not in the same cell
//        while((r3.currentCol == r1.currentCol && r3.currentRow == r1.currentRow) || (r3.currentCol == r2.currentCol && r3.currentRow == r2.currentRow))
//        {
//            r3.currentCol = rand.nextInt(0,99);
//            r3.currentRow = rand.nextInt(0,99);
//        }
        r3.currentCol = rand.nextInt(0,99);
        r3.currentRow = rand.nextInt(0,99);

        //explore.addRobot(r3);
        explore.start();
        sleep(5000);

        System.out.println(explore.isTaskComplete());

      //we can pause the robots bu pressing number keys
        Scanner scanner = new Scanner(System.in);
        while(true)
        {
            int key = scanner.nextInt();

            //get the status of the robot
            for(Robot r : explore.getRobots())
            {
                if(r.getRobotId() == key)
                {
                    if(r.isRunning)
                    {
                        r.pause();
                        break;

                    }
                    else
                    {
                        r.resume();
                        break;

                    }
                }
                else
                {
                    System.out.println("Robot "+ r.getRobotId() + " is not running or does not exist");
                }
            }
        }

    }
}
