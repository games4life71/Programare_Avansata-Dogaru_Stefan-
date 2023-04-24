import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SharedMemory
{
    private List<Token> tokenList = new ArrayList<>();

    public SharedMemory(List<Token> tokens)
    {
        this.tokenList = tokens;
        //shuffle the tokens
        Collections.shuffle(this.tokenList);
    }

    public SharedMemory(int n)
    {
        for (int i =0 ; i < n ; i++)
        {
            this.tokenList.add(new Token(i));
        }

    }

    public synchronized List<Token> extractTokens(int howMany)
    {
        List<Token> extracted = new ArrayList<>();

        for (int i = 0; i < howMany; i++)
        {
            if (this.tokenList.size() > 0)
            {
              //  System.out.println("Extracting token " + this.tokenList.get(0).getId());
                extracted.add(this.tokenList.remove(0));
            //System.out.println("Extracting token " + this.tokenList.get(0).getId());

            }
            else break;
        }

       // System.out.println("Extracted " + extracted.size() + " tokens");

        return extracted;
    }
}
