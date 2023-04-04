public class Token
{
    private final int id;

    public Token(int id)
    {
        this.id  = id;

    }

    public int getId()
    {
        return id;
    }

    @Override
    public String toString()
    {
        //convert id to a string
        return String.valueOf(this.getId());
    }



}
