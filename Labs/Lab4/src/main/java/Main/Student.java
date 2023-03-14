package Main;

import java.util.ArrayList;
import java.util.List;

/**
 * Student class that defines the behavior of a student
 */
public class Student implements Comparable
{

    private String name;

    /**
     * List of projects that the student is wanting
     */
    private List<Project> projects = new ArrayList<Project>();
    public Student()
    {

    }

    public Student(String name)
    {
        this.name = name;
    }

    /**
     * Add a new project to the list
     * @param project
     */
    public void addProject(Project project)
    {
        projects.add(project);
    }

    /**
     * Print the projects that the student is wanting
     */
    public void printProjects()
    {
        for (Project project : projects)
        {
            System.out.println(project);
        }
    }

    /**
     * Get the name of a project
     * @param  index the index of the project in the list
     * @return
     */
    public Project  getProject(int index)
    {
        return projects.get(index);
    }

    @Override
    public int compareTo(Object o)
    {
       //comapre the strings

        return this.name.compareTo(((Student)o).name);

    }

    /**
     * Returns the name of the student
     * @return
     */
    public String toString()
    {
        return this.name;
    }

}




