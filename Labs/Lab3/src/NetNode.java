import java.util.HashMap;

/**
 * Class that holds the connections of a specific network node
 */
public class NetNode implements Comparable
{
    private HashMap<Node,String> connections = new HashMap<Node,String>();


    /**
     * Add a connection to the node
     * @param n Node to be connected
     * @param type Type of connection
     */
    public void addConnection(Node n,String type)
    {
        connections.put(n, type);
    }

    /**
     * Remove a connection from the node
     * @param n Node to be disconnected
     */
    public void removeConnection(Node n)
    {
        connections.remove(n);
    }

    /**
     * Get the type of connection between this node and the specified node
     * @param n
     * @return
     */
    public String getConnectionType(Node n)
    {
        return connections.get(n).toString();
    }

    /**
     * Get the number of connections of this node
     * @return int  Number of connections
     */
    public int  getConnectionCount()
    {
        return connections.size();
    }

    /**
     * Get the connections of this node
     * @return String of connections
     */
    public String getConnection()
    {
        StringBuilder sb = new StringBuilder();
        for(Node n : connections.keySet())
        {
            sb.append(n.getName());
            sb.append(" ");
            sb.append(connections.get(n));
        }
        return sb.toString();
    }
    public boolean equals(Object o)
    {
        if(o instanceof NetNode)
        {
            NetNode n = (NetNode)o;
            if(this.getConnectionCount() == n.getConnectionCount())
            {
                return true;
            }
        }
        return false;
    }
    @Override
    public int compareTo(Object o)
    {
        if(this.getConnectionCount() > ((NetNode)o).getConnectionCount())
        {
            return 1;
        }
        else if(this.getConnectionCount() < ((NetNode)o).getConnectionCount())
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }
}
