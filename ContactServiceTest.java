package contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

class ContactServiceTest {
	
	private ContactService contactService;

    @BeforeEach
    public void setup() {
        contactService = new ContactService();
    }

    @Test
    @DisplayName("Test adding a valid contact")
    public void testAddContact() {
        Contact contact = new Contact("Santa123", "Santa", "Claus", "1234567890", "North Pole");
        contactService.addContact(contact);

        assertAll(
            () -> assertNotNull(contactService.getContact("Santa123"), "Contact should exist after addition"),
            () -> assertEquals(contact, contactService.getContact("Santa123"), "Added contact does not match")
        );
    }

    @Test
    @DisplayName("Test adding duplicate contact throws exception")
    public void testAddDuplicateContact() {
        Contact contact = new Contact("Santa123", "Santa", "Claus", "1234567890", "North Pole");
        contactService.addContact(contact);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> contactService.addContact(contact));
        assertEquals("Contact ID already exists.", exception.getMessage());
    }

    @Test
    @DisplayName("Test deleting a contact")
    public void testDeleteContact() {
        Contact contact = new Contact("Santa123", "Santa", "Claus", "1234567890", "North Pole");
        contactService.addContact(contact);

        contactService.deleteContact("Santa123");
        assertNull(contactService.getContact("Santa123"), "Contact should be null after deletion");
    }

    @Test
    @DisplayName("Test deleting a non-existent contact throws exception")
    public void testDeleteNonExistentContact() {
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> contactService.deleteContact("NonExistentID"),
            "Expected IllegalArgumentException for non-existent ID");

        assertEquals("Contact ID not found.", exception.getMessage());
    }

    @Test
    @DisplayName("Test updating a contact's details")
    public void testUpdateContact() {
        Contact contact = new Contact("Santa123", "Santa", "Claus", "1234567890", "North Pole");
        contactService.addContact(contact);

        contactService.updateContact("Santa123", "Rudolph", "Reindeer", "0987654321", "Christmas Town");

        Contact updatedContact = contactService.getContact("Santa123");
        assertAll(
            () -> assertEquals("Rudolph", updatedContact.getFirstName(), "First name mismatch after update"),
            () -> assertEquals("Reindeer", updatedContact.getLastName(), "Last name mismatch after update"),
            () -> assertEquals("0987654321", updatedContact.getPhone(), "Phone number mismatch after update"),
            () -> assertEquals("Christmas Town", updatedContact.getAddress(), "Address mismatch after update")
        );
    }

    @Test
    @DisplayName("Test updating a non-existent contact throws exception")
    public void testUpdateNonExistentContact() {
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> contactService.updateContact("NonExistentID", "NewFirst", "NewLast", "0987654321", "New Address"),
            "Expected IllegalArgumentException for non-existent ID");

        assertEquals("Contact ID not found.", exception.getMessage());
    }
}
