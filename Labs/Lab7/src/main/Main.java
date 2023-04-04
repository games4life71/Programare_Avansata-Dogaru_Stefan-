public class Main
{
    public static void main(String[] args)
    {

        Exploration explore = new Exploration();
        explore.addRobot(new Robot(1,explore));
        explore.addRobot(new Robot(2,explore));
        explore.addRobot(new Robot(3 ,explore));
        explore.start();

    }
}
