package com.example.addressbook;

import java.util.ArrayList;
import java.util.List;

public class MockContactDAO implements IContactDAO {
    /**
     * A static list of contacts to be used as a mock database.
     */
    private static final ArrayList<Contact> contacts = new ArrayList<>();
    private static int autoIncrementedId = 0;

    public MockContactDAO() {
        // Add some initial contacts to the mock database
        addContact(new Contact("Nour", "Spear", "0423423423", "nourspear@example.com"));
        addContact(new Contact("Noah", "Spear",  "0427286444", "noahspear@example.com"));
        addContact(new Contact("Noel", "Spear",  "0413954993", "noelspear@example.com"));
    }

    @Override
    public void addContact(Contact contact) {
        contact.setId(autoIncrementedId);
        autoIncrementedId++;
        contacts.add(contact);
    }

    @Override
    public void updateContact(Contact contact) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getId() == contact.getId()) {
                contacts.set(i, contact);
                break;
            }
        }
    }

    @Override
    public void deleteContact(Contact contact) {
        contacts.remove(contact);
    }

    @Override
    public Contact getContact(int id) {
        for (Contact contact : contacts) {
            if (contact.getId() == id) {
                return contact;
            }
        }
        return null;
    }

    @Override
    public List<Contact> getAllContacts() {
        return new ArrayList<>(contacts);
    }
}