package org.contacts.command;

import org.contacts.contact.Contact;

public interface MenuAction {


    void execute(PhoneBook phoneBook);

    default void list(PhoneBook phoneBook){
        if (count(phoneBook) > 0) {
            for (Contact contact : phoneBook.book) {
                System.out.println(phoneBook.book.indexOf(contact) + 1 + ". " + contact.getName());
            }
        } else {
            System.out.println("No info in the book");
        }

    }

    static int count(PhoneBook phoneBook) {
        return phoneBook.book.size();
    }
}
