package org.contacts.command;

import org.contacts.ContactFactory;
import org.contacts.contact.Contact;

public class Add implements MenuAction {

    @Override
    public void execute(PhoneBook phoneBook) {
        System.out.print("Enter the type (person, organization): ");
        String type = phoneBook.scanner.nextLine();
        ContactFactory contactFactory = new ContactFactory(phoneBook.scanner);
        Contact contact = contactFactory.createContact(type);
        if (contact != null){
            phoneBook.book.add(contact);
            System.out.println("The record added.");
        } else {
            System.out.println("Cannot add this kind of record.");
        }
    }
}
