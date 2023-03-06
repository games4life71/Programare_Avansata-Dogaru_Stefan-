public class Company implements  Comparable,Node
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
    public int compareTo(Object o)
    {
        if(this.companyName.compareTo(((Company)o).companyName) > 0)
        {
            return 1;
        }
        else if(this.companyName.compareTo(((Company)o).companyName) < 0)
        {
            return -1;
        }
        else
        {
            return 0;
        }
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
}

