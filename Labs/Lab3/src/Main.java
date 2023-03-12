import java.util.*;

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

        //print on the screen the info of each node

//        for (Node n : nodes)
//        {
//            System.out.println(n);
//        }


        // ----------HOMEWORK PART ------------
//       nodes.sort(
//               new Comparator <Node>()
//                  {
//                    @Override
//                      public int compare(Node n1,Node n2)
//                    {
//                         return n1.getName().compareTo(n2.getName());
//                    }
//                  }
//
//       );

        Network network = new Network();

        network.addNode(p1);
        network.addNode(p2);
        network.addNode(p3);
        network.addNode(c1);
        network.addNode(new Designer("Adobe", "San Jose, CA"));

        network.getNode(0).addConnection(p2,"friend");
        network.getNode(0).addConnection(p3,"friend");
        network.getNode(0).addConnection(c1,"friend");
        network.getNode(1).addConnection(p3,"friend");

       // network.getImportance(network.getNode(1));

        network.printNodes();

        network.sort();
        System.out.println();
        System.out.println("[SORTED]:");
        network.printNodes();














    }


}

