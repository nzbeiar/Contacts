package org.contacts.contact;

import org.contacts.command.PhoneBook;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Contact implements Serializable {

    protected String name = "";
    protected String number = "";

    LocalDateTime createdDate;

    LocalDateTime editedDate;

    public abstract Contact edit(PhoneBook phoneBook);
    public abstract String representation();

    public Contact(String name, String number) {
        this.name = name;
        if (validateNumber(number)) {
            this.number = number;
        }
        this.createdDate = LocalDateTime.now().withSecond(0).withNano(0);
        this.editedDate = LocalDateTime.from(createdDate);
    }


    protected boolean validateNumber(String number) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDateTime getEditedDate() {
        return editedDate;
    }

    public void setEditedDate(LocalDateTime editedDate) {
        this.editedDate = editedDate;
    }
}
