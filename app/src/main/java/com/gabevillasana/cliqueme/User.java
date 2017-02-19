package com.gabevillasana.cliqueme;

/**
 * Created by gbotev on 2/18/17.
 */

public class User {

    private String name;
    private String email;
    private String locale;
    private String gender;

    public User(String name, String email, String locale, String gender) {
        this.name = name;
        this.email = email;
        this.locale = locale;
        this.gender = gender;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getLocale() {
        return this.locale;
    }

    public String getGender() {
        return this.gender;
    }

}
