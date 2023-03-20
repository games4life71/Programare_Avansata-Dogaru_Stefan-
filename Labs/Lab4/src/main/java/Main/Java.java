package Main;

import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.IntStream;

public class Java
{
    public static void main(String[] args)
    {
        //--------------------COMPULSORY PART-------


        //create a list of students
        List<Student> stud_list = new LinkedList<>();

        Faker[] fake_stud = new Faker[10];

        //[OPTIONAL] generate 30 fake project name
        //Faker[] fake_proj = new Faker[30];

        //generate 10 fakers
        IntStream.range(0, 10).forEach(i -> fake_stud[i] = new Faker());

        //IntStream.range(0, 10).forEach(i -> fake_proj[i] = new Faker());


        //use streams to create 10 students and assign them random names
        IntStream.range(0, 10).forEach(i -> stud_list.add(new Student(fake_stud[i].name().fullName())));

        //create a set of projects
        Set<Project> proj_set = new TreeSet<>(Project::compareTo);

        Set<Project> proj_set_copy = new TreeSet<>(Project::compareTo);


        //use streams to create 20 projects
        IntStream.range(0, 10).forEach(i -> proj_set.add(new Project("P" + i)));
        proj_set_copy.addAll(proj_set);


        //sort the students
        // stud_list.sort((s1, s2) -> s1.compareTo(s2));

        //print the students and projects

//        for (Student student : stud_list)
//        {
//            System.out.println(student);
//        }
//
//        for (Project project : proj_set)
//        {
//            System.out.println(project);
//        }


        // ------------- HOMEWORK PART ---------------------

        //create a problem instance
        ProblemInstance problemInstance = new ProblemInstance(stud_list);

        //assign a random project to each student once

        for (Student student : stud_list)
        {
            //get a random project
            //get a random number -->  how many projects a student will have in preferences
            int rand_number = new Random().nextInt(proj_set_copy.size() - 1);

            for (int i = 0; i < rand_number; i++)
            {
                Project random_project = (Project) proj_set_copy.toArray()[(int) (Math.random() * proj_set_copy.size())];
                //add the preference to the problem instance
                problemInstance.addPreference(student, random_project);
                //remove the project from the set
                proj_set_copy.remove(random_project);
            }

        }

        problemInstance.PrintPreferences();

        //-----print the students that have a number of preferences lower than the average number of preferences---

        // problemInstance.PrintAverage();

        //solve the problem instance using a greedy algorithm
        System.out.println();

        problemInstance.solveGreedy(proj_set);
        System.out.println("Solved using greedy algorithm : ");

        problemInstance.PrintAssignments();


    }

}

