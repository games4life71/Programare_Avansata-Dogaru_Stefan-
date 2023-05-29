package app;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import main.*;

public class LocaleExplorer {

    public static void main(String[] args) {

        //read command from keyboard and print out the result
        String command = "";
        Scanner reader = new Scanner(System.in);
        getLocaleInfo info = new getLocaleInfo();
        ResourceBundle messages = ResourceBundle.getBundle("main.resources.Message", Locale.getDefault());

        while (!command.equals("exit")) {
            System.out.print("Enter command: ");
            command = reader.next();
            //execute command and print out the result in the specified locale
            if (command.equals("info")) {

                try {
                    Locale locale = Locale.getDefault();
                    info.setLocale(locale);
                    //info.setLocale(Locale.getDefault());
                    info.displayLocaleInfo();

                } catch (NullPointerException e) {
                    System.out.println(messages.getString("invalid"));
                }

            } else if (command.contains("locales.set")) {
                //get the locale from the command

                //split by dots
                String[] locale = command.split("\\.");
                try {
                    SetLocale setLocale = new SetLocale(locale[2], locale[3]);
                    messages = ResourceBundle.getBundle("main.resources.Message", Locale.getDefault());
                    String message = messages.getString("locale.set");
                    String formattedMessage = MessageFormat.format(message, setLocale.getLocale());
                    System.out.println(formattedMessage);

                } catch (IndexOutOfBoundsException e) {
                    System.out.println(messages.getString("invalid"));
                }

            } else if (command.equals("locales.display")) {
                messages = ResourceBundle.getBundle("main.resources.Message",Locale.getDefault());
                System.out.println(messages.getString("locales"));
                DisplayLocales displayLocales = new DisplayLocales();
                displayLocales.displayLocales();
            } else if (command.equals("exit")) {
                System.out.println("Exiting...");
            } else {
                //get the message from the resource bundle and display it in the specified locale
                messages = ResourceBundle.getBundle("main.resources.Message", Locale.getDefault());
                System.out.println(messages.getString("invalid"));
            }


        }


    }

}
