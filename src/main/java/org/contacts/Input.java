package org.contacts;


import org.contacts.command.*;

import java.util.Scanner;

public class Input {

    PhoneBook phoneBook;
    MenuController menuController;

    public Input() {
        try (Scanner scanner = new Scanner(System.in)) {
            this.phoneBook = new PhoneBook(scanner);
            while (true) {
                this.menuController = new MenuController(phoneBook);
                System.out.print("Enter action (add, remove, edit, count, info, exit): ");
                String action = scanner.nextLine();
                switch (action) {
                    case "add" -> {
                        menuController.setMenuAction(new Add());
                    }
                    case "remove" -> {
                        menuController.setMenuAction(new Remove());
                    }
                    case "edit" -> {
                        menuController.setMenuAction(new Edit());
                    }
                    case "count" -> {
                        System.out.printf("This Phone Book has %d records.%n"
                                ,MenuAction.count(phoneBook));
                    }
                    case "info" -> {
                        menuController.setMenuAction(new Info());
                    }
                    case "exit" -> {
                        return;
                    }
                    default -> {
                        System.out.println("No such option!");
                    }
                }
                menuController.executeCommand();
                System.out.println();
            }
        }
    }
}
