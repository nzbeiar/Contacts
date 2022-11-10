package org.contacts.command;

import org.contacts.contact.Contact;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBook{

    List<Contact> book;
    transient public Scanner scanner;

    public PhoneBook() {
        this.book = new ArrayList<>();
    }

    public List<Contact> getBook() {
        return book;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public void setBook(List<Contact> book) {
        this.book = book;
    }
}
