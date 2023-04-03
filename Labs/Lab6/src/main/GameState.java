import java.util.ArrayList;
import java.util.List;

/**
 * A class that defines the behaviour of a game state --> saves the minimum information needed to recreate the game state
 */
public class GameState
{
    private final int numVertices;
//    private final int x;
//    private final int y;
    private final double edgeProbability;
    private final List<Lines> lines = new ArrayList<>();
    private  final List<MyPoint> points = new ArrayList<>();

    private  int[][]  adjacencyMatrix = new int[100][100];

    public GameState(int numVertices,  double edgeProbability)
    {
        this.numVertices = numVertices;
       // this.x = x;
       // this.y = y;
        this.edgeProbability = edgeProbability;
    }
    public GameState()
    {
        this.numVertices = 0;
        // this.x = x;
        // this.y = y;
        this.edgeProbability = 0;
    }

    public int getNumVertices()
    {
        return numVertices;
    }

//    public int getX()
//    {
//        return x;
//    }
//
//    public int getY()
//    {
//        return y;
//    }

    public double getEdgeProbability()
    {
        return edgeProbability;
    }

    public List<Lines> getLines()
    {
        return lines;
    }

    public List<MyPoint> getPoints()
    {
        return points;
    }

    public  int[][] getAdjacencyMatrix()
    {
        return adjacencyMatrix;
    }

    public  void setAdjacencyMatrix(int[][] adjacencyMatrix)
    {
        this.adjacencyMatrix = adjacencyMatrix;
    }
    public  void setLines(List<Lines> lines)
    {
        this.lines.addAll(lines);
    }

    public void setPoints(List<MyPoint> points)
    {
        this.points.addAll(points);
    }
}
