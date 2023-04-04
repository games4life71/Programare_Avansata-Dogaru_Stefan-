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
        String s = "";
        for (Token t : tokens)
        {
            s += t.toString();
        }
        return s;
    }
}
