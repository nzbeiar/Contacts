package org.contacts.ContactBuilder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactBuilder implements Builder {

    private String name = "";
    private String lastname = "";
    private String number = "";

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public void setNumber(String number) {
        if (validateNumber(number)) {
            this.number = number;
        } else {
            System.out.println("Wrong number format!");
            this.number = "";
        }
    }

    public Contact getResult() {
        return new Contact(name, lastname, number);
    }


    public boolean validateNumber(String number) {
        Pattern plusOrNothing = Pattern.compile("^\\+?[^+]+");
        Matcher plusMatcher = plusOrNothing.matcher(number);
        Pattern firstGroup = Pattern.compile(".?\\(\\w+\\)([-\\s][^()]+)+"
                + "|.?\\w+([-\\s]\\w{2,})+" +
                "|.?\\w+" +
                "|.?\\(\\w+\\)" +
                "|[^()]+[-\\s]\\(\\w{2,}\\)[^()]*"
        );
        Matcher fstMatcher = firstGroup.matcher(number);

        return plusMatcher.matches() && fstMatcher.matches();
    }

    public ContactBuilder fromContact (Contact contact) {
        this.name = contact.getName();
        this.lastname = contact.getLastName();
        this.number = contact.getNumber();
        return this;
    }

}
