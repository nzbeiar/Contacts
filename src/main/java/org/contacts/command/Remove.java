package org.contacts.command;


import org.contacts.contact.Contact;

public class Remove implements MenuAction {

    Contact contactToRemove;

    public Remove(Contact contact) {
        this.contactToRemove = contact;
    }


    @Override
    public void execute(PhoneBook phoneBook) {
        phoneBook.book.remove(contactToRemove);
    }
}
