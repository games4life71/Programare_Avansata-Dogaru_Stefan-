package Main;


/**
 * Project class that defines the behavior for a project
 */
public class Project implements  Comparable
{
  private String name;


  /**
   * @return the name
   */
  public String toString()
  {
      return this.name;
  }

  public Project(String name)
  {
      this.name = name;
  }

  public Project()
  {

  }
  @Override
    public int compareTo(Object o)
  {
      // TODO Auto-generated method stub
        return this.name.compareTo(((Project)o).name);
  }

}
