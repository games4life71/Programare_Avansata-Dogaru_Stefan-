import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashSet;
import java.util.Properties;

public class Main
{
    private static final String HTML_TEMPLATE = "D:\\Projects\\Java\\Programare_Avansata-Dogaru_Stefan-\\Labs\\Lab5\\src\\main\\resources\\html_template.vm";

    public static void main(String[] args) throws IOException
    {           //     ---------------- COMPULSATORY PART ---------------


//        // Create a new instance of the class
//        Catalog catalog = new Catalog();
//        // Add a new book to the catalog
//        catalog.add(new Book("03121","autor","mihai enat","edituraRO","artifact"));
//        catalog.add(new Book("1312","autor","mihai enat","edituraRO","horror"));
//        catalog.add(new Book("1231","autor","mihai enat","edituraRO","romantic"));
//        // Add a new article to the catalog
//
//        catalog.add(new Article("123","autor","mihai","edituraEN","drama"));
//        catalog.add(new Article("1234","autor","mihai","edituraEN","drama"));
//        catalog.save();
//        catalog.load("D:\\Projects\\Java\\Programare_Avansata-Dogaru_Stefan-\\Labs\\Lab5\\target\\assets\\catalog.json");
//
//
//        //print the catalog
//        System.out.println(catalog);
        //open the report and generate an HTML report

        Catalog catalog = new Catalog();
        catalog.setId("1");

        Document doc1 = new Document("1", "docker_file", "C:\\Users\\stefy\\Desktop\\docker.txt", false, ".txt", "empty");
        Document doc2 = new Document("2", "aws_pem", "C:\\Users\\stefy\\Desktop\\ec2_key.pem", false, ".pem", "empty");
        Document doc3 = new Document("3", "steam", "C:\\Users\\stefy\\Desktop\\steam_Rec.txt", false, ".txt", "empty");
//
//
        Command add = new AddCommand(catalog, doc1);
        add.execute();
        Command add1 = new AddCommand(catalog, doc2);
        add1.execute();
        Command add2 = new AddCommand(catalog, doc3);
        add2.execute();
        Command save = new SaveCommand(catalog);
        save.execute();
        LoadCommand load = new LoadCommand(catalog);
        load.execute(); // load has now the catalog from the file 'catalog.json'




        Command list = new ListCommand(catalog);
        list.execute();
        Command view = new ViewCommand(catalog.getDocuments().stream().findFirst().get());
        view.execute();
        Command report = new ReportCommand(catalog);
        report.execute();
    }
}
