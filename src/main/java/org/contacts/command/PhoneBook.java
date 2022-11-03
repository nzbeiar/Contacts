package org.contacts.command;

import org.contacts.contact.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBook {

    List<Contact> book;
    public Scanner scanner;

    public PhoneBook(Scanner scanner) {
        this.book = new ArrayList<>();
        this.scanner = scanner;
    }

    public List<Contact> getBook() {
        return book;
    }


}
