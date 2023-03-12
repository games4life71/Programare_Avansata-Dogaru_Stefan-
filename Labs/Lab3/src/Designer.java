/**
 * Defines a Designer class that extends the Person class.
 */
public class Designer extends  Person
{


    private String prefferedSoftware;

    public Designer(String prefferedSoftware , String name)
    {
        super(name);
        this.prefferedSoftware = prefferedSoftware;
    }

    public Designer()
    {
        super("John Doe");
        this.prefferedSoftware = "Adobe Photoshop";
    }


}
