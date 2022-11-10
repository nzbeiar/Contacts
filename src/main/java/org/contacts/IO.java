package org.contacts;


import org.contacts.command.*;
import java.io.*;
import java.util.Scanner;

public class IO {

    PhoneBook phoneBook;
    MenuController menuController;

    public IO() throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            phoneBook = new PhoneBook();
            phoneBook.setScanner(scanner);
            while (true) {
                this.menuController = new MenuController(phoneBook);
                System.out.print("[menu] Enter action (add, list, search, count, exit): ");
                String action = scanner.nextLine();
                switch (action) {
                    case "add" -> {
                        menuController.setMenuAction(new Add());
                        menuController.executeCommand();
                    }
                    case "list" -> {
                        menuController.setMenuAction(new List(menuController));
                        menuController.executeCommand();
                    }
                    case "search" -> {
                        menuController.setMenuAction(new Search(menuController));
                        menuController.executeCommand();
                    }
                    case "count" -> {
                        System.out.printf("This Phone Book has %d records.%n"
                                , MenuAction.count(phoneBook));
                    }
                    case "exit" -> {
                        return;
                    }
                    default -> {
                        System.out.println("No such option!");
                    }
                }
                System.out.println();
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
