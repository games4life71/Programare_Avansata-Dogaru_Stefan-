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

//    @Override
//    public String getName()
//    {
//        return super.getName();
//    }

//    @Override
//    public int compareTo(Person o)
//    {
//        if(this.getName().compareTo(((Designer)o).getName()) > 0)
//        {
//            return 1;
//        }
//        else if(this.getName().compareTo(((Designer)o).getName()) < 0)
//        {
//            return -1;
//        }
//        else
//        {
//            return 0;
//        }
//    }

}
