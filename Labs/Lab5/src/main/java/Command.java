import java.io.IOException;

public abstract class Command
{
    public abstract String CommandName();

    /**
     * Execute the command
     */
    public abstract void execute() throws IOException;


}


