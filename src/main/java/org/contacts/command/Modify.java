package org.contacts.command;


import org.contacts.contact.Contact;

import java.io.IOException;
import java.util.Scanner;

public class Modify implements MenuAction{


    MenuController menuController;
    Contact contactToModify;

    public Modify(MenuController menuController, Contact contactToModify) {
        this.menuController = menuController;
        this.contactToModify = contactToModify;
    }

    @Override
    public void execute(PhoneBook phoneBook) throws IOException {
        Scanner scanner = phoneBook.scanner;
        while (true) {
            System.out.print("[record] Enter action (edit, delete, menu): ");
            String recordAction = scanner.nextLine();
            switch (recordAction) {
                case "edit" -> {
                    menuController.setMenuAction(new Edit(contactToModify));
                    menuController.executeCommand();
                }
                case "delete" -> {
                    menuController.setMenuAction(new Remove(contactToModify));
                    menuController.executeCommand();
                }
                case "menu" -> {
                    return;
                }

            }
            System.out.println(contactToModify);
            System.out.println();
        }

    }
}
