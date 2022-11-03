package org.contacts.command;

import org.contacts.contact.Contact;

public class Edit implements MenuAction {
    @Override
    public void execute(PhoneBook phoneBook) {
        if (MenuAction.count(phoneBook) < 1) {
            System.out.println("No records to edit!");
        } else {
            list(phoneBook);
            System.out.print("Select a record: ");
            int index = Integer.parseInt(phoneBook.scanner.nextLine());
            Contact contact = phoneBook
                    .book
                    .get(index-1)
                    .edit(phoneBook);
            phoneBook.book.set(index-1, contact);
        }
    }
}
