import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {


        //-------------COMPULSATORY PART ------------
        // Create a new instance of the class
        List<Node> nodes = new ArrayList<Node>();


        Person p1 = new Person("John Doe");
        Person p2 = new Person("Doe");
        Programmer p3 = new Programmer("Java" , "Johnny Cash");
        Company c1 = new Company("Microsoft", "Redmond, WA");

        if(nodes.contains(c1))
        {
            System.out.println("Company already exists");
        }

        else
        {
            nodes.add(c1);
        }
        if(nodes.contains(p1))
        {
            System.out.println("Person already exists");
        }
        else
        {
            nodes.add(p1);
        }

        if(nodes.contains(p2))
        {
            System.out.println("Person already exists");
        }
        else
        {
            nodes.add(p2);
        }

        if(nodes.contains(p3))
        {
            System.out.println("Person already exists");
        }
        else
        {
            nodes.add(p3);
        }


        for (Node n : nodes)
        {
            System.out.println(n.getName());
        }


        // ----------HOMEWORK PART ------------


    }


}

