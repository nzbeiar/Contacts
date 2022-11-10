package org.contacts.command;



import org.contacts.contact.Contact;
import org.contacts.contact.OrgContact;
import org.contacts.contact.RegularContact;

import java.io.IOException;
import java.util.ArrayList;

public interface MenuAction {


    void execute(PhoneBook phoneBook) throws IOException;

    default void list(PhoneBook phoneBook){
        ArrayList<Contact> book = (ArrayList<Contact>) phoneBook.book;
        if (count(phoneBook) > 0) {
            for (Contact contact : book) {
                String name = "";
                if (contact instanceof OrgContact) {
                    name = contact.getName();
                } else if (contact instanceof RegularContact) {
                    name = contact.getName() + " " + ((RegularContact) contact).getSurname();
                }
                System.out.println(book.indexOf(contact) + 1 + ". " + name);
                System.out.println();
            }
        } else {
            System.out.println("No info in the book");
        }

    }

    static int count(PhoneBook phoneBook) {
        return phoneBook.book.size();
    }
}
