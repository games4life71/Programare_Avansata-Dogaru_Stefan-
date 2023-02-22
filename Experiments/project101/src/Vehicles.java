public abstract class Vehicles
{
    protected  String name;
    protected  int maxSpeed;
    protected int maxPassengers;
    protected int maxLoad;
    protected int maxFuel;
    protected int computeFuelConsumption(int distance)
    {
        return this.maxFuel * this.maxFuel / this.maxSpeed;
    }

}

