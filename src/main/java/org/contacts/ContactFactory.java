package org.contacts;


import org.contacts.contact.Contact;
import org.contacts.contact.OrgContact;
import org.contacts.contact.RegularContact;

import java.util.Scanner;

public class ContactFactory {

    Scanner scanner;
    public ContactFactory(Scanner scanner) {
        this.scanner = scanner;
    }

    public Contact createContact(String type) {
        Contact contact;
        if (type.equals("person")) {
            System.out.print("Enter the name: ");
            String name = scanner.nextLine();
            System.out.print("Enter the surname: ");
            String surname =scanner.nextLine();
            System.out.print("Enter the birth date: ");
            String birthdate = scanner.nextLine();
            if (!validateDate(birthdate)){
                birthdate = "";
            }
            System.out.print("Enter the gender (M, F): ");
            String gender = scanner.nextLine();
            if (!validateGender(gender)){
                gender = "";
            }
            System.out.print("Enter the number: ");
            String number = scanner.nextLine();
            contact = new RegularContact(name,surname,birthdate,gender,number);
        } else if (type.equals("organization")) {
            System.out.print("Enter the organization name: ");
            String name  = scanner.nextLine();
            System.out.print("Enter the address: ");
            String address = scanner.nextLine();
            System.out.print("Enter the number: ");
            String number = scanner.nextLine();
            contact = new OrgContact(name,address,number);
        } else {
            return null;
        }
        return contact;
    }
    
    private boolean validateDate(String string) {
        if ("".equals(string)) {
            System.out.println("Bad birth date!");
            return false;
        }
        return true;
    }

    private boolean validateGender(String string) {
        if (!string.matches("[M,F]")) {
            System.out.println("Bad gender!");
            return false;
        }
        return true;
    }
}