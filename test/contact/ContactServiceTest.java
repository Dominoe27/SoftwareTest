package contact;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

public class ContactServiceTest {

    // Test adding a new contact.
    @Test
    void testAddContact_withUniqueId_addsSuccessfully() {
        ContactService service = new ContactService();
        Contact contact = new Contact("001", "Dom", "Smith", "1234567890", "123 Main");
        service.addContact(contact);
        assertEquals("Dom", service.getContact("001").getFirstName());
    }

    // Test adding a contact with an ID.
    @Test
    void testAddContact_withDuplicateId_throwsException() {
        ContactService service = new ContactService();
        service.addContact(new Contact("001", "Dom", "Smith", "1234567890", "123 Main"));
        assertThrows(IllegalArgumentException.class, () -> 
            service.addContact(new Contact("001", "Jane", "Doe", "9876543210", "456 Elm"))
        );
    }

    // Test deleting an contact
    @Test
    void testDeleteContact_withExistingId_deletesSuccessfully() {
        ContactService service = new ContactService();
        service.addContact(new Contact("001", "Dom", "Smith", "1234567890", "123 Main"));
        service.deleteContact("001");
        assertNull(service.getContact("001")); // Should return null
    }

    // Test deleting a non-existent contact
    @Test
    void testDeleteContact_withNonexistentId_throwsException() {
        ContactService service = new ContactService();
        assertThrows(NoSuchElementException.class, () -> service.deleteContact("999"));
    }

    // Test updating all fields of a contact
    @Test
    void testUpdateContactFields_withValidData_updatesSuccessfully() {
        ContactService service = new ContactService();
        service.addContact(new Contact("001", "Dom", "Smith", "1234567890", "123 Main"));

        service.updateFirstName("001", "Alex");
        service.updateLastName("001", "Johnson");
        service.updatePhone("001", "0987654321");
        service.updateAddress("001", "789 Sunset Blvd");

        Contact updated = service.getContact("001");
        assertEquals("Alex", updated.getFirstName());
        assertEquals("Johnson", updated.getLastName());
        assertEquals("0987654321", updated.getPhone());
        assertEquals("789 Sunset Blvd", updated.getAddress());
    }

    // Test updating a field on a non-existent contact
    @Test
    void testUpdateFirstName_withInvalidId_throwsException() {
        ContactService service = new ContactService();
        assertThrows(NullPointerException.class, () -> service.updateFirstName("999", "Ghost"));
    }
}
