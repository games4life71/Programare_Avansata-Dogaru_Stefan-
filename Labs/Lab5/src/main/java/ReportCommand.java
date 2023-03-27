import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Properties;
import java.util.Scanner;

/**
 * Class that defines the behaviour of a ReportCommand that creates (and opens) an HTML report representing the content of the catalog.
 */
public class ReportCommand extends Command
{
    private Catalog catalog;  // the catalog to be reported

    public ReportCommand(Catalog catalog)
    {
        this.catalog = catalog;
    }

    @Override
    public String CommandName()
    {
        return "report";
    }

    @Override
    public void execute() throws IOException
    {

        VelocityEngine ve = new VelocityEngine();

        //set the path to the template
        Properties p = new Properties();
        p.put("file.resource.loader.path", "D:\\Projects\\Java\\Programare_Avansata-Dogaru_Stefan-\\Labs\\Lab5\\src\\main\\resources");
        ve.init(p);

        VelocityContext context = new VelocityContext();

        //for each document in the catalog, add it to the context
        context.put("catalog_id", this.catalog.getId()); //replace catalog_id with the id of the catalog
        context.put("documents", this.catalog.getDocuments()); //replace documents with the list of documents in the catalog


        Template t = ve.getTemplate("html_template.vm");

        //open the report and generate a HTML report
        StringBuilder fileName = new StringBuilder();
        fileName.append("D:\\Projects\\Java\\Programare_Avansata-Dogaru_Stefan-\\Labs\\Lab5\\target\\assets\\");
        fileName.append("catalog");
        fileName.append(this.catalog.getId());
        fileName.append(".html");
        Writer writer = new FileWriter(new File(fileName.toString()));
        t.merge(context, writer);
        //Velocity.mergeTemplate(t, "UTF-8", context, writer);
        writer.flush();
        writer.close();

        System.out.println("[DEBUG] Report " + "'" + fileName.substring(fileName.lastIndexOf("\\") + 1, fileName.length()) + "'" + " generated successfully!");
        //prompt the user to open the report
        System.out.println("Saved report to  default path : " + fileName.toString());
        System.out.println("Do you want to open the report? (y/n)");

        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();

        if (answer.equals("y"))
        {
            Desktop.getDesktop().browse(new File(fileName.toString()).toURI());
        }

    }

}
