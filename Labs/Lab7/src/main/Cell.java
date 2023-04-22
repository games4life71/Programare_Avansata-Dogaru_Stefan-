import java.util.ArrayList;
import java.util.List;

public class Cell
{
    //cell is the same thing as a list of tokens
    private final List<Token> tokens;
    private boolean visited = false;
    public Cell()
    {
        this.tokens = new ArrayList<>();
        this.visited = false;
    }
    private  int row;
    private  int col;

    public int getRow()
    {
        return row;
    }

    public void setRow(int row)
    {
        this.row = row;
    }

    public int getCol()
    {
        return col;
    }

    public void setCol(int col)
    {
        this.col = col;
    }

    public void addToken(Token token)
    {
        this.tokens.add(token);
    }

    public boolean isVisited()
    {
        return visited;
    }

    public void setVisited(boolean visited)
    {
        this.visited = visited;
    }

    public List<Token> getTokens()
    {
        return tokens;
    }

    public void removeAll()
    {
        this.tokens.clear();
    }

    public String toString()
    {
     //loop through the tokens and print them
        StringBuilder s = new StringBuilder();
        for (Token t : tokens)
        {
            s.append(t.toString());
        }
        return s.toString();
    }
}
