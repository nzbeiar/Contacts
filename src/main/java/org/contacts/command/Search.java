package org.contacts.command;

import org.contacts.contact.Contact;
import org.contacts.contact.OrgContact;
import org.contacts.contact.RegularContact;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Search implements MenuAction{

    MenuController menuController;
    public Search(MenuController menuController) {
        this.menuController = menuController;
    }

    @Override
    public void execute(PhoneBook phoneBook) throws NumberFormatException {
        Scanner scanner = phoneBook.scanner;
        while (true) {
            System.out.print("Enter search query: ");
            String query = scanner.nextLine().toLowerCase();
            Pattern pattern = Pattern.compile(".*%s.*".formatted(query));
            ArrayList<Contact> foundContacts = new ArrayList<>();
            for (Contact el : phoneBook.getBook()) {
                Matcher matcher = pattern.matcher(el.representation().toLowerCase());
                if (matcher.matches()) {
                    foundContacts.add(el);
                }
            }
            for (Contact el : foundContacts) {
                System.out.printf("%d. %s%n", foundContacts.indexOf(el)+1
                        , el instanceof OrgContact ? el.getName() :
                                el instanceof  RegularContact ? el.getName() + " " + ((RegularContact) el).getSurname() : "");
            }

            System.out.println();
            System.out.print("[search] Enter action ([number], back, again): ");
            String action = scanner.nextLine();
            try {
                int index = Integer.parseInt(action);
                Contact contactToModify = foundContacts.get(index-1);
                System.out.println(contactToModify);
                System.out.println();
                menuController.setMenuAction(new Modify(menuController,contactToModify));
                menuController.executeCommand();
                return;
            } catch (NumberFormatException e) {
                if ("back".equals(action)) {
                    return;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
