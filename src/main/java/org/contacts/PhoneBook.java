package org.contacts;

import org.contacts.ContactBuilder.Contact;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {

    List<Contact> book;

    public PhoneBook() {
        this.book = new ArrayList<>();
    }

    public List<Contact> getBook() {
        return book;
    }



}
