package org.contacts.contact;

import org.contacts.command.PhoneBook;

import java.time.LocalDateTime;
import java.util.Scanner;

public class RegularContact extends Contact {

    private String surname;
    private String birthdate;
    private String gender;

    public RegularContact(String name, String surname, String birthdate, String gender, String number) {
        super(name, number);
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.gender = gender;
    }

    @Override
    public Contact edit(PhoneBook phoneBook) {
        Scanner scanner = phoneBook.scanner;
        System.out.println("Select a field (name, surname, birth, gender, number): ");
        String field = scanner.nextLine();
        switch (field) {
            case "name" -> {
                String newName = scanner.nextLine();
                this.setName(newName);
            }
            case "surname" -> {
                String newSurname = scanner.nextLine();
                this.setSurname(newSurname);
            }
            case "birth" -> {
                String newBirth = scanner.nextLine();
                this.setBirthdate(newBirth);
            }
            case "gender" -> {
                String newGender = scanner.nextLine();
                this.setGender(newGender);
            }
            case "number" -> {
                String newNumber = scanner.nextLine();
                if (validateNumber(newNumber)) {
                    this.setNumber(newNumber);
                }
            }
        }
        System.out.println("The record updated!");
        this.setEditedDate(LocalDateTime.now().withSecond(0).withNano(0));
        return this;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n"
                + "Surname: " + surname + "\n"
                + "Birth date: " + ("".equals(birthdate) ? "[no data]" : birthdate) + "\n"
                + "Gender: " + ("".equals(gender) ? "[no data]" : gender) + "\n"
                + "Number: " + super.number + "\n"
                + "Time created: " + super.createdDate + "\n"
                + "Time last edit:" + super.editedDate;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
