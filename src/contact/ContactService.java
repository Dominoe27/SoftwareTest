package contact;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class ContactService {

    // In-memory storage for contacts using contact ID as the key
    private final Map<String, Contact> contacts = new HashMap<>();

    // Adds a new contact to the service, ensures the ID is unique
    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID already exists");
        }
        contacts.put(contact.getContactId(), contact);
    }

    // Deletes a contact by ID, throws exception if contact not found
    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new NoSuchElementException("Contact ID not found");
        }
        contacts.remove(contactId);
    }

    // Updates the contact's first name
    public void updateFirstName(String contactId, String firstName) {
        getContact(contactId).setFirstName(firstName);
    }

    // Updates the contact's last name
    public void updateLastName(String contactId, String lastName) {
        getContact(contactId).setLastName(lastName);
    }

    // Updates the contact's phone number
    public void updatePhone(String contactId, String phone) {
        getContact(contactId).setPhone(phone);
    }

    // Updates the contact's address
    public void updateAddress(String contactId, String address) {
        getContact(contactId).setAddress(address);
    }

    // Retrieves a contact by ID. Returns null if not found 
    public Contact getContact(String contactId) {
        return contacts.get(contactId); // no exception thrown
    }
}