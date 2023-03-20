package Main;

import java.util.*;
import java.util.concurrent.RunnableFuture;

/**
 * A class that describres a problem instance for the project allocation problem
 */
public class ProblemInstance
{

    // Map that stores the preferences of each student
    /**
     * The preferences of each student
     * Key is the student
     * Value is the list of projects
     */
    private Map<Student, LinkedList<Project>> preferences = new HashMap<Student, LinkedList<Project>>();

    /**
     * The assignments of each student
     */
    private Map<Student, Project> assignments = new HashMap<Student, Project>();

    public ProblemInstance(List<Student> student_list)
    {
        //initialize the preferences map

        for (Student student : student_list)
        {
            preferences.put(student, new LinkedList<Project>());
        }

    }

    /**
     * Add a preference to the map
     *
     * @param s Student that has the preference
     * @param p Project that is preferred
     */
    public void addPreference(Student s, Project p)
    {
        //get the list of projects for the student
        LinkedList<Project> list = preferences.get(s);

        //if the list is null, create a new list
        list = list == null ? new LinkedList<Project>() : list;

        //add the project to the list
        if (!list.contains(p))
        {
            list.add(p);
        } else
        {
            System.out.println("Project already exists in pteferences of the student" + s.toString());
            return;
        }

        //update the map
        this.preferences.put(s, list);


    }

    /**
     * Get the preferences of a student
     *
     * @param s Student
     * @return LinkedList of projects
     */
    public LinkedList<Project> getPreferences(Student s)
    {
        return preferences.get(s);
    }

    /**
     * Print the preferences of each student
     */
    public void PrintPreferences()
    {
        preferences.entrySet().stream().forEach(e -> System.out.println(e.getKey().toString() + " " + e.getValue().toString()));
    }

    /**
     * Print the students that have a number of preferences lower than the average number of preferences
     */
    public void PrintAverage()
    {
        //get the average number of preferences
        double average = preferences.values().stream().mapToInt(LinkedList::size).average().getAsDouble();


        //print the students that have a number of preferences lower than the average number of preferences
        preferences.entrySet().stream().filter(e -> e.getValue().size() < average).forEach(e -> System.out.println(e.getKey().toString()));

    }


    /**
     * Algorithm that solves the problem instance using a greedy algorithm
     *
     * @param projects projects that are available
     */
    public void solveGreedy(Set<Project> projects)
    {
        //list of projects that are not assigned

        LinkedList<Project> unassigned_projects = new LinkedList<Project>();

        unassigned_projects.addAll(List.copyOf(projects));

        //list of students that have no project assigned
        LinkedList<Student> unassigned_students = new LinkedList<Student>();

        unassigned_students.addAll(List.copyOf(preferences.keySet()));


        //sort the list of students by the number of preferences descending

        unassigned_students.sort(Comparator.comparingInt(o -> preferences.get(o).size()).reversed());



        //loop through the list of  students that have no project assigned
        for (Student student : unassigned_students)
        {
            //get the list of preferences for the student
            LinkedList<Project> preferences = getPreferences(student);

            //for each project in the list of preferences
            if (preferences.size() > 0)
            {

                //for each project in the list of preferences
                for (Project project : preferences)
                {
                    //if the project is not assigned
                    if (!assignments.containsValue(project))
                    {
                        //assign the project to the student
                        assignments.put(student, project);
                        //remove the project from the list of unassigned projects
                        unassigned_projects.remove(project);

                        break;
                    }
                }

                //if no project was assigned to the student
                if(!assignments.containsKey(student))
                {
                    //assign the first unnassigned project to the student
                    assignments.put(student, unassigned_projects.getFirst());
                    //remove the project from the list of unassigned projects
                    unassigned_projects.remove(unassigned_projects.getFirst());

                }
            }
            else
            {   //if the student has no preferences

                // System.out.println("Student "+   student.toString() +" has no preferences .. ");

                //assign the first unnassigned project to the student
                assignments.put(student, unassigned_projects.getFirst());
                //remove the project from the list of unassigned projects
                unassigned_projects.remove(unassigned_projects.getFirst());

            }
        }


        //for each student assign the first project from the list of preferences that is not assigned
        //if all the projects are assigned, assign the first project from the list of preferences that is assigned to the student with the lowest number of preferences


    }

    public void PrintAssignments()
    {
        assignments.entrySet().stream().forEach(e -> System.out.println(e.getKey().toString() + " " + e.getValue().toString()));
    }
}
