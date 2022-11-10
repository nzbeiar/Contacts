package org.contacts.command;


import org.contacts.contact.Contact;

import java.io.*;
import java.util.ArrayList;

public class MenuController {
    MenuAction menuAction;
    PhoneBook phoneBook;

    String filename;



    public MenuController(PhoneBook phoneBook) throws IOException, ClassNotFoundException {
        this.phoneBook = phoneBook;
        filename = "phoneBook.db";
        File file = new File(filename);
        if (!file.exists()) {
            serialize(phoneBook.getBook(),filename);
        }
        try {
            ArrayList<Contact> contacts = (ArrayList<Contact>) deserialize(filename);
            phoneBook.setBook(contacts);
        } catch (Exception e) {
            System.out.println("Error during deserialization");
        }

    }

    public void setMenuAction(MenuAction menuAction) {
        this.menuAction = menuAction;
    }

    public void executeCommand() throws IOException {
        if (menuAction != null) {
            menuAction.execute(phoneBook);
        }
        try {
            serialize(phoneBook.getBook(),filename);
        } catch (Exception e) {
            System.out.println("Error during serialization");
        }


    }

    public static void serialize(Object obj, String fileName) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(obj);
        oos.close();
    }

    public static Object deserialize(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        BufferedInputStream bis = new BufferedInputStream(fis);
        ObjectInputStream ois = new ObjectInputStream(bis);
        Object obj = ois.readObject();
        ois.close();
        return obj;
    }
}
