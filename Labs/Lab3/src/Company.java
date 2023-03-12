/**
 * Class that defines a network node which represents a company
 */
public class Company extends NetNode implements  Comparable,Node
{
    private String companyName;
    private String companyAddress;


    public Company(String companyName, String companyAddress)
    {
        this.companyName = companyName;
        this.companyAddress = companyAddress;
    }

    public Company()
    {
        this.companyName = "Anonymous";
        this.companyAddress = "1234 Main St";
    }

    public String getCompanyName()
    {
        return companyName;
    }

    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }

    public String getCompanyAddress()
    {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress)
    {
        this.companyAddress = companyAddress;
    }

    @Override
    public String getName()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(companyName);
        sb.append(" ");
        sb.append("[COMPANY]");

        return sb.toString();
    }

    @Override public boolean equals(Object o)
    {
        if(o instanceof Company)
        {
            if(this.companyName.equals(((Company)o).companyName))
            {
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString()
    {
        return this.getName();
    }
}

