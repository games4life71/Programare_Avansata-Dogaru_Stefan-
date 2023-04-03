import java.awt.*;

public class MyPoint extends Point
{

    private int id;

    public MyPoint(int x, int y)
    {
        super(x, y);
    }

    public MyPoint(int x, int y, int id)
    {
        super(x, y);
        this.id = id;
    }


    public MyPoint()
    {
        super();
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }


}
