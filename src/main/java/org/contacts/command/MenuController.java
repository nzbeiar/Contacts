package org.contacts.command;

public class MenuController {
    MenuAction menuAction;
    PhoneBook phoneBook;

    public MenuController(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    public void setMenuAction(MenuAction menuAction) {
        this.menuAction = menuAction;
    }

    public void executeCommand() {
        if (menuAction != null) {
            menuAction.execute(phoneBook);
        }

    }
}
