/*
 Example class for inheritance

  */
public final class Car extends Vehicles
{
    public Car(String name, int maxSpeed, int maxPassengers, int maxLoad, int maxFuel)
    {
        this.name = name;
        this.maxSpeed = maxSpeed;
        this.maxPassengers = maxPassengers;
        this.maxLoad = maxLoad;
        this.maxFuel = maxFuel;
    }


    public static void  Race(Car c1 , Car c2 )
    {
        if (c1.maxSpeed > c2.maxSpeed)
            System.out.println(c1.name + " is faster than " + c2.name);
        else
            System.out.println(c2.name + " is faster than " + c1.name);
    }

    public void printCar()
    {
        System.out.println("Car name: " + name);
        System.out.println("Max speed: " + maxSpeed);
        System.out.println("Max passengers: " + maxPassengers);
        System.out.println("Max load: " + maxLoad);
        System.out.println("Max fuel: " + maxFuel);
    }
}
