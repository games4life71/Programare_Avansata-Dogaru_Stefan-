import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class that represent a specific network represented by a list of nodes
 */
public class Network
{

    private List<NetNode> nodes = new ArrayList<NetNode>();
    public void sort()
    {
        Collections.sort(nodes);
    }

    /**
     * Add a node to the network
     * @param n Node to be added to the network
     */
    public void addNode(NetNode n)
    {
        nodes.add(n);
    }

    /**
     * Get the number of nodes in the network
     * @return Number of nodes in the network
     */
    public int getNumberOfNodes()
    {
        return nodes.size();
    }

    /**
     * Get a node from the network
     * @param index Index of the node to be retrieved
     * @return Node at the specified index
     */
    public NetNode getNode(int index)
    {
        return nodes.get(index);
    }
    /**
     * Remove a node from the network
     * @param n Node to be removed
     */
    public void removeNode(NetNode n)
    {
        nodes.remove(n);
    }

    /**
     * Remove a node from the network
     * @param index Index of the node to be removed
     */
    public void removeNode(int index)
    {
        nodes.remove(index);
    }

    /**
     * Get the importance of a node( number of connections/ degree of the node
     * @param n node to be checked
     */
    public void getImportance(NetNode n)
    {
        if(!this.nodes.contains(n))
        {
            System.out.println("[ERROR] Node doesnt exist ... ");
            return;
        }



            System.out.println( "There are " + n.getConnectionCount() + " connections");
            System.out.println();
            System.out.println("Connections: ");
            System.out.println(n.getConnection());
    }

    /**
     * Print the nodes in the network
     */
    public void printNodes()
    {
        for(NetNode n : nodes)
        {
            System.out.println(n);
        }
    }


}
