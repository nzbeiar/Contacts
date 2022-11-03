package org.contacts.command;

public class Remove implements MenuAction {

    @Override
    public void execute(PhoneBook phoneBook) {
        if(MenuAction.count(phoneBook) < 1) {
            System.out.println("No records to remove!");
        } else {
            list(phoneBook);
            System.out.print("Select a record: ");
            String index = phoneBook.scanner.nextLine();
            phoneBook.book.remove(Integer.parseInt(index)-1);
            System.out.println("The record removed!");
        }
    }
}
