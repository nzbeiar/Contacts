package org.contacts;


import org.contacts.ContactBuilder.Contact;
import org.contacts.ContactBuilder.ContactBuilder;

import java.util.Scanner;

public class Input {

    PhoneBook phoneBook;

    public Input() {
        this.phoneBook = new PhoneBook();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Enter action (add, remove, edit, count, list, exit): ");
                String action = scanner.nextLine();
                switch (action) {
                    case "add" -> {
                        Contact contact = contactInput(scanner);
                        phoneBook.book.add(contact);
                        System.out.println("The record added.");

                    }
                    case "remove" -> {
                        if(phoneBook.getBook().size() < 1) {
                            System.out.println("No records to remove!");
                        } else {
                            list(phoneBook);
                            System.out.print("Select a record: ");
                            String index = scanner.nextLine();
                            phoneBook.book.remove(Integer.parseInt(index)-1);
                            System.out.println("The record removed!");
                        }
                    }
                    case "edit" -> {
                        if(phoneBook.getBook().size() < 1) {
                            System.out.println("No records to edit!");
                        } else {
                            list(phoneBook);
                            contactEdit(scanner);
                        }
                    }
                    case "count" -> System.out.printf("This Phone Book has %d records.%n",phoneBook.getBook().size());
                    case "list" -> {
                        list(phoneBook);
                    }

                    case "exit" -> {
                        return;
                    }
                    default -> {
                        System.out.println("No such option!");
                    }
                }
            }
        }

    }
    private boolean list(PhoneBook phoneBook) {
        if (phoneBook.getBook().size() > 0) {
            for (Contact contact : phoneBook.getBook()) {
                System.out.println(phoneBook.getBook().indexOf(contact) + 1 + ". " + contact);
            }
        } else {
            return false;
        }
        return true;
    }

    private void contactEdit(Scanner scanner) {
        System.out.print("Select a record: ");
        int index = Integer.parseInt(scanner.nextLine());
        Contact contact = phoneBook.book.get(index - 1);
        ContactBuilder contactBuilder = new ContactBuilder().fromContact(contact);
        System.out.print("Select a field (name, surname, number): ");
        String field = scanner.nextLine();
        switch (field) {
            case "name" -> {
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                contactBuilder.setName(name);
            }
            case "surname" -> {
                System.out.print("Enter surname: ");
                String surname = scanner.nextLine();
                contactBuilder.setLastname(surname);
            }
            case "number" -> {
                System.out.print("Enter number: ");
                String number = scanner.nextLine();
                contactBuilder.setNumber(number);
            }
        }
        phoneBook.book.set(index - 1, contactBuilder.getResult());
        System.out.println("The record updated!");
    }

    private Contact contactInput (Scanner scanner){
            ContactBuilder contactBuilder = new ContactBuilder();
            System.out.print("Enter the name: ");
            String name = scanner.nextLine();
            System.out.print("Enter the surname: ");
            String surname = scanner.nextLine();
            System.out.print("Enter the number: ");
            String number = scanner.nextLine();
            contactBuilder.setName(name);
            contactBuilder.setLastname(surname);
            contactBuilder.setNumber(number);

            return contactBuilder.getResult();
        }
}
