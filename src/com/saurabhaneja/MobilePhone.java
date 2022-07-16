package com.saurabhaneja;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber){
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public boolean addNewcontact (Contact contact) {
        if(findContact(contact) >= 0) {
            System.out.println("Contact is already in Phonebook !");
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    public boolean updateContact (Contact oldContact, Contact newContact) {
        int index = findContact(oldContact);
        if(index < 0){
            System.out.println(oldContact.getName() + " is not in Phonebook.");
            return false;
        }
        this.myContacts.set(index, newContact);
        System.out.println(oldContact.getName() + " is replaced with " + newContact.getName());
        return true;
    }

    public boolean removeContact(Contact contact) {
        int index = findContact(contact);
        if(index < 0) {
            System.out.println(contact.getName() + " is not in Phonebook.");
            return false;
        }
        this.myContacts.remove(index);
        return true;
    }

    private int findContact(Contact contact) {
        return this.myContacts.indexOf(contact);
    }
    private int findContact(String contactName) {
        for(int i=0; i<this.myContacts.size(); i++) {
            Contact contact = this.myContacts.get(i);
            if(contact.getName().equals(contactName))
                return i;
        }
        return -1;
    }

//    public String queryContact (Contact contact) {
//        if(findContact(contact) >= 0)
//            return contact.getName();
//        return null;
//    }

    public Contact queryContact (String name) {
        int index = findContact(name);
        if(index >= 0){
            return this.myContacts.get(index);
        }
        return null;
    }

    public void printContacts() {
        System.out.println("Contact List");
        int i = 1;
        for(Contact contact : this.myContacts) {
            System.out.println(i++ + ". " + contact.getName() + " -> " + contact.getPhoneNumber());
        }
    }

}
