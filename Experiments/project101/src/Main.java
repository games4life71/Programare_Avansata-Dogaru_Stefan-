public class Main
{
    public static void main(String[] args)
    {


        Car c1 = new Car("BMW", 254, 5, 1000, 100);
        Car  c2 = new Car("Audi",100,2,100,32);
        Car.Race(c1,c2);
        System.out.println("The fuel consumption is " + c2.computeFuelConsumption(200) + " L/100km");

    }
}