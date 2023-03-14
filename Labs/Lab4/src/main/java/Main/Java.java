package Main;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class Java
{
    public static void main(String[] args)
    {

        //create a list of students
        List<Student> stud_list = new LinkedList<Student>();

        //use streams to create 10 students
        IntStream.range(0, 10).forEach(i -> stud_list.add(new Student("Student " + i)));

        //create a set of projects
        Set<Project> proj_set = new TreeSet<Project>(Project::compareTo);


        //use streams to create 20 projects
        IntStream.range(0,20).forEach(i -> proj_set.add(new Project("Project "+i)));


        //sort the students
        stud_list.sort((s1, s2) -> s1.compareTo(s2));

        //print the students and projects

        for (Student student : stud_list)
        {
            System.out.println(student);
        }

        for (Project project : proj_set)
        {
            System.out.println(project);
        }
    }

}

