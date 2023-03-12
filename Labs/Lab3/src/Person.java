import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Class that defines a network node which represents a person
 */
public  class Person extends NetNode implements Node
{

    private String name;
    private String birthDate;


    public Person(String name)
    {
        this.name = name;
    }

    //default constructor
    public Person()
    {
        this.name = "John Doe";
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
    @Override
    public String toString()
    {

       return  this.getName();
    }

}

