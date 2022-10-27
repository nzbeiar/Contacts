package org.contacts;

import java.util.Scanner;

public class Input {

    PhoneBook phoneBook;

    public Input() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the name of the person:");
            String name = scanner.nextLine();
            System.out.println("Enter the surname of the person:");
            String surnname = scanner.nextLine();
            System.out.println("Enter the number:");
            String number = scanner.nextLine();
            System.out.println();
            try {
                this.phoneBook = new PhoneBook();
                phoneBook.book.add(new Contact(name, surnname, number));
                System.out.println("A record created!");
                System.out.println("A Phone Book with a single record created!");

            } catch (Exception e) {
                System.out.println("Something went wrong");
            }

        }
    }
}
