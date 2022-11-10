package org.contacts.command;


import org.contacts.contact.Contact;

import java.io.IOException;

public class List implements MenuAction{

    MenuController menuController;

    public List(MenuController menuController) {
        this.menuController = menuController;
    }

    @Override
    public void execute(PhoneBook phoneBook) {
        if (MenuAction.count(phoneBook) > 0) {
            list(phoneBook);
            while (true) {
                System.out.print("[list] Enter action ([number], back): ");
                try {
                    int index = Integer.parseInt(phoneBook.scanner.nextLine());
                    Contact contactToModify = phoneBook.getBook().get(index - 1);
                    System.out.println(contactToModify);
                    System.out.println();
                    menuController.setMenuAction(new Modify(menuController,contactToModify));
                    menuController.executeCommand();
                    return;
                } catch (NumberFormatException | IOException e) {
                        return;
                    }
                }
            } else {
                System.out.println("The contact book is empty!");
        }
    }
}
