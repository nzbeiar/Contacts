package org.contacts.command;

public class Info implements MenuAction{

    @Override
    public void execute(PhoneBook phoneBook) {
        if (MenuAction.count(phoneBook) > 0) {
            list(phoneBook);
            System.out.println("Select a record: ");
            int record = Integer.parseInt(phoneBook.scanner.nextLine());
            System.out.println(phoneBook.book.get(record- 1));
        } else {
            System.out.println("The contact book is empty!");
        }

    }
}
