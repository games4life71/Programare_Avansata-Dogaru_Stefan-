import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public  class Person implements Comparable<Person>,Node
{

    private String name;
    private String birthDate;



    /**
     * A map of connections to other nodes and the type of connection
     * key = Node
     * value = type of connection(String)
     */
    private Map<Node,String> connections = new HashMap<Node,String>();
    public Person(String name)
    {
        this.name = name;
    }

    public Person()
    {
        this.name = "John Doe";
    }


    @Override
    public int compareTo(Person o)
    {
        if(this.name.compareTo(o.name) > 0)
        {
            return 1;
        }
        else if(this.name.compareTo(o.name) < 0)
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }
    @Override
    public String getName()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(" ");
        sb.append("[PERSON]");
        return sb.toString();

    }

    public void addConnection(Node n,String type)
    {
        connections.put(n,type);
    }
    public void removeConnection(Node n)
    {
        connections.remove(n);
    }
    //get a connection
    public String getConnection(Node n)
    {
        return connections.get(n);
    }
    //get all connections
    public Map<Node,String> getConnections()
    {
        return connections;
    }
    @Override public boolean equals(Object o)
    {
        if(o instanceof Person)
        {
            Person p = (Person)o;
            if(this.name.equals(p.name))
            {
                return true;
            }
        }
        return false;
    }

}

