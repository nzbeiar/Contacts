package org.contacts.contact;


import org.contacts.command.PhoneBook;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Scanner;

public class OrgContact extends Contact {

    String address;

    public OrgContact(String name, String address, String number) {
        super(name,number);
        this.address = address;
    }

    @Override
    public Contact edit(PhoneBook phoneBook) {
        Scanner scanner = phoneBook.scanner;
        System.out.println("Select a field (name, address, number): ");
        String field = scanner.nextLine();
        switch (field) {
            case "name" -> {
                String newName = scanner.nextLine();
                this.setName(newName);
            }
            case "address" -> {
                String newAddress = scanner.nextLine();
                this.setAddress(newAddress);
            }
            case "number" -> {
                System.out.print("Enter new number: ");
                String newNumber = scanner.nextLine();
                if (validateNumber(newNumber)) {
                    this.setNumber(newNumber);
                } else {
                    System.out.println("Wrong number format");
                }
            }
        }
        System.out.println("Saved");
        this.setEditedDate(LocalDateTime.now().withSecond(0).withNano(0));
        return this;
    }

    @Override
    public String representation() {
        return name + address + number + createdDate + editedDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Organization name: " + name + "\n"
                + "Address: " + address + "\n"
                + "Number: " + super.number + "\n"
                + "Time created: " + super.createdDate + "\n"
                + "Time last edit:" + super.editedDate;
    }

}
