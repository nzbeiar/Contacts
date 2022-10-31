package org.contacts.ContactBuilder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contact {

    private String name;
    private String lastName;
    private String number = "";


    public Contact(String name, String lastName, String number) {
        this.name = name;
        this.lastName = lastName;
        this.number = number;
    }

    @Override
    public String toString() {
        return name + " " + lastName +", " + ("".equals(number)? "[no number]" : number);
    }

    public String getName() {
        return name;
    }


    public String getLastName() {
        return lastName;
    }


    public String getNumber() {
        return number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNumber(String number) {
            this.number = number;
    }
}
