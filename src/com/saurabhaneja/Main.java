package com.saurabhaneja;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("96XXX861XX");

    public static void main(String[] args) {
	// write your code here
        boolean quit = false;
        startPhone();
        printActions();
        while (!quit) {
            System.out.println("\nEnter action: (6 to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("\nShutting down...");
                    quit = true;
                    break;

                case 1:
                    mobilePhone.printContacts();
                    break;

                case 2:
                    addNewContact();
                    break;

                case 3:
                    updateContact();
                    break;

                case 4:
                    removeContact();
                    break;

                case 5:
                    queryContact();
                    break;

                case 6:
                    printActions();
                    break;
            }

        }

    }

    private static void addNewContact() {
        System.out.println("Enter new contact name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();
        while(!isValid(phoneNumber)){
            System.out.println("Enter a valid Phone Number: ");
            phoneNumber = scanner.nextLine();
        }
        Contact newContact = Contact.createContact(name, phoneNumber);
        if(mobilePhone.addNewcontact(newContact)) {
            System.out.println("New contact added in Phonebook, \nname: " + name + ", PhoneNumber: " + phoneNumber);
        }
        else{
            System.out.println("Can't add, " + name + " already in Phonebook");
        }
    }

    private static void updateContact() {
        System.out.println("Enter existing contact name:");
        String name = scanner.nextLine();
        Contact existingContact = mobilePhone.queryContact(name);
        while(existingContact == null) {
            System.out.println("Contact not found.");
            return ;
        }
        System.out.println("Enter new contact name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter new Contact Phone Number: ");
        String newNumber = scanner.nextLine();
        while(!isValid(newNumber)){
            System.out.println("Enter a valid Phnoe Number: ");
            newNumber = scanner.nextLine();
        }
        Contact newContact = Contact.createContact(newName, newNumber);
        if(mobilePhone.updateContact(existingContact, newContact)) {
            System.out.println("Successfully updated contact");
        }
        else {
            System.out.println("Error updating contact");
        }
    }

    private static void removeContact() {
        System.out.println("Enter contact name to delete: ");
        String name = scanner.nextLine();
        Contact contact = mobilePhone.queryContact(name);
        if(contact == null) {
            System.out.println("Contact not found.");
        }
        if(mobilePhone.removeContact(contact)){
            System.out.println("Contact successfully deleted");
        }
        else {
            System.out.println("Error deletting contact");
        }
    }

    private static void queryContact() {
        System.out.println("Enter contact name to query: ");
        String name = scanner.nextLine();
        Contact contact = mobilePhone.queryContact(name);
        if(contact == null) {
            System.out.println("Contact not found");
            return ;
        }
        System.out.println("Name: " + contact.getName() + " Phone Number: " + contact.getPhoneNumber());
    }


    private static void startPhone() {
        System.out.println("Starting Phone......");
    }

    private static void printActions() {
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0  - to shutdown\n" +
                "1 -> to print contacts\n" +
                "2 -> to add a new contact\n" +
                "3 -> to update existing an existing contact\n" +
                "4 -> to remove an existing contact\n" +
                "5 -> query if an existing contact exists\n" +
                "6 -> to print a list of available actions.");
        System.out.println("Choose your action: ");
    }

    private static boolean isValid(String s)
    {
        if(s.length() != 10 || s.charAt(0) == '0')
            return false;

        for(int i=0; i<10; i++){
            int c = s.charAt(i);
            if(c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

}

// github link
// https://github.com/AnejaGitHub/PhoneBook.git