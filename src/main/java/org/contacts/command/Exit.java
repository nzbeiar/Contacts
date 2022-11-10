package org.contacts.command;

import java.util.Scanner;

public class Exit implements MenuAction{

    @Override
    public void execute(PhoneBook phoneBook) {
        System.exit(0);
    }
}
