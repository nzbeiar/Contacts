package org.contacts.command;



import org.contacts.contact.Contact;


public class Edit implements MenuAction {


    Contact contactToEdit;

    public Edit(Contact contact) {
        this.contactToEdit = contact;
    }

    @Override
    public void execute(PhoneBook phoneBook) {
        int index = phoneBook.getBook().indexOf(contactToEdit);
        Contact contact = phoneBook.getBook()
                .get(index)
                .edit(phoneBook);
        phoneBook.getBook().set(index, contact);
    }
}
