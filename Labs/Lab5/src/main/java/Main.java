import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException
    {           //     ---------------- COMPULSATORY PART ---------------



        // Create a new instance of the class
        Catalog catalog = new Catalog();
        // Add a new book to the catalog
        catalog.add(new Book("03121","autor","mihai enat","edituraRO","artifact"));
        catalog.add(new Book("1312","autor","mihai enat","edituraRO","horror"));
        catalog.add(new Book("1231","autor","mihai enat","edituraRO","romantic"));
        // Add a new article to the catalog

        catalog.add(new Article("123","autor","mihai","edituraEN","drama"));
        catalog.add(new Article("1234","autor","mihai","edituraEN","drama"));
        catalog.save();
        catalog.load("D:\\Projects\\Java\\Programare_Avansata-Dogaru_Stefan-\\Labs\\Lab5\\target\\assets\\catalog.json");


        //print the catalog
        System.out.println(catalog);

    }
}
