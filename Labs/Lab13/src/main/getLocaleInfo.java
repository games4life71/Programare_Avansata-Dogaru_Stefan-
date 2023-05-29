package main;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;

public class getLocaleInfo {

    private Locale locale;

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public void displayLocaleInfo() {

        System.out.println("Country: " + locale.getDisplayCountry());
        System.out.println("Language: " + locale.getDisplayLanguage());
        System.out.println("Currency: " + Currency.getInstance(locale));
        //print the week days and months of the current locale
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(locale);

        //display the week days
        System.out.println("Week days: " + Arrays.toString(dateFormatSymbols.getWeekdays()));
        System.out.println("Months: " + Arrays.toString(dateFormatSymbols.getMonths()));
        //display the current date
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, locale);
        Date today = new Date();
        System.out.println("Today:" + dateFormat.format(today));
    }

}
