import java.util.ArrayList;
import java.util.List;

public class ExplorationMap
{
    Cell[][] matrix;
    private final SharedMemory mem;

    public ExplorationMap(SharedMemory mem)
    {
        this.matrix = new Cell[100][100];
        //initialize the matrix
        for (int i = 0; i < 100; i++)
        {
            for (int j = 0; j < 100; j++)
            {
                matrix[i][j] = new Cell();
            }
        }

        //print the matrix
//        for (int i = 0; i < 100; i++)
//        {
//            for (int j = 0; j < 100; j++)
//            {
//                System.out.print(matrix[i][j] + " ");
//            }
//
//            System.out.println();
//        }


        this.mem = mem;
    }

    {
        this.matrix = new Cell[100][100];

    }

    public Boolean visit(int row, int col, Robot robot)
    {
        synchronized (matrix[row][col])
        {
            //if the cell is not visited
            //make the robot extract a token
            if (matrix[row][col].isVisited())
            {
                System.out.println("[debug] cell " + row + " " + col + " is already visited");
                return false;
            } else
            {

                List<Token> extracted = mem.extractTokens(10);
                //convert the list of tokens to a cell
                Cell mycell = new Cell();
                mycell.getTokens().addAll(extracted);

                matrix[row][col] = mycell;  //add the extracted tokens to the cell

                // System.out.println("Extracted token " + extracted.get(0) + " from shared memory");
                matrix[row][col].setVisited(true); //set the cell as visited
                return true;
            }
        }

    }

    @Override
    public String toString()
    {
        //loop the map and print the tokens
        for (int i = 0; i < 100; i++)
        {
            for (int j = 0; j < 100; j++)
            {
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }

        return null;
    }

}
