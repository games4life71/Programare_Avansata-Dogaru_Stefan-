import java.awt.*;

//class that defines the behavior of the Lines object
public class Lines
{

    //a line it's connected to two points
    private MyPoint p1;
    private MyPoint p2;
    private Boolean isColored = false;

    public Boolean getColored()
    {
        return isColored;
    }

    public void setColored(Boolean colored)
    {
        isColored = colored;
    }

    //constructor
    public Lines(MyPoint p1, MyPoint p2)
    {
        this.p1 = p1;
        this.p2 = p2;
    }

    public MyPoint getP1()
    {
        return p1;
    }

    public void setP1(MyPoint p1)
    {
        this.p1 = p1;
    }

    public MyPoint getP2()
    {
        return p2;
    }

    public void setP2(MyPoint p2)
    {
        this.p2 = p2;
    }
}
