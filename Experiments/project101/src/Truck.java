public final class Truck extends Vehicles
{
    public Truck(String name, int maxSpeed, int maxPassengers, int maxLoad, int maxFuel)
    {
        this.name = name;
        this.maxSpeed = maxSpeed;
        this.maxPassengers = maxPassengers;
        this.maxLoad = maxLoad;
        this.maxFuel = maxFuel;
    }


    public void printTruck()
    {
        System.out.println("Truck name: " + name);
        System.out.println("Max speed: " + maxSpeed);
        System.out.println("Max passengers: " + maxPassengers);
        System.out.println("Max load: " + maxLoad);
        System.out.println("Max fuel: " + maxFuel);
    }
}
