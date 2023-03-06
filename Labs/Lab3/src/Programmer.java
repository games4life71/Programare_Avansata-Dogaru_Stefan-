public class Programmer extends Person
{


    private String prefferedLanguage;

    public Programmer( String prefferedLanguage,String name)
    {
        super(name);
        this.prefferedLanguage = prefferedLanguage;
    }

    public Programmer()
    {
        super("John Doe");
        this.prefferedLanguage = "Java";
    }


//    @Override
//    public String getName()
//    {
//        StringBuilder sb = new StringBuilder();
//        sb.append(super.getName());
//        sb.append(" ");
//        sb.append("[PROGRAMMER]");
//        return sb.toString();
//    }

//    @Override
//    public int compareTo(Person o)
//    {
//        if(this.getName().compareTo(o.getName()) > 0)
//        {
//            return 1;
//        }
//        else if(this.getName().compareTo(o.getName()) < 0)
//        {
//            return -1;
//        }
//        else
//        {
//            return 0;
//        }
//    }
}
