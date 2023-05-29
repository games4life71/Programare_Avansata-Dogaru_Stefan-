package main;

import java.util.Locale;


/**
 * This class is used to set the application locale.
 */
public class SetLocale {
    private final String language;
    private final String country;

    public SetLocale(String language, String country) {
        this.language = language;
        this.country = country;
        Locale.setDefault(new Locale(this.language, this.country));
    }

    public String getLanguage() {
        return this.language;
    }

    public String getCountry() {
        return this.country;
    }


    public Object getLocale() {
        return Locale.getDefault();
    }
}
