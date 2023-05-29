package main;

import java.util.ResourceBundle;
import java.util.Locale;


/**
 * This class is used to display the available locales.
 */
public class DisplayLocales {

    public void displayLocales() {
        Locale[] locales = Locale.getAvailableLocales();
        for (Locale locale : locales) {
            System.out.println(locale.getDisplayCountry() + " " + locale.getDisplayLanguage(locale));
        }

    }

}
