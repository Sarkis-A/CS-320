package contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class ContactTest {
	
	@Test
    @DisplayName("Test that a valid contact is created successfully")
    public void testValidContactCreation() {
        Contact contact = new Contact("Santa123", "Santa", "Claus", "1234567890", "North Pole");

        assertAll(
            () -> assertEquals("Santa123", contact.getContactId(), "Contact ID mismatch"),
            () -> assertEquals("Santa", contact.getFirstName(), "First name mismatch"),
            () -> assertEquals("Claus", contact.getLastName(), "Last name mismatch"),
            () -> assertEquals("1234567890", contact.getPhone(), "Phone number mismatch"),
            () -> assertEquals("North Pole", contact.getAddress(), "Address mismatch")
        );
    }

	@Test
    @DisplayName("Test invalid contact creation throws exceptions for each field")
    public void testInvalidContactCreation() {
        assertAll(
            // Contact ID validation
            () -> assertThrows(IllegalArgumentException.class, 
                () -> new Contact(null, "Santa", "Claus", "1234567890", "North Pole"), 
                "Contact ID should not be null"),
            () -> assertThrows(IllegalArgumentException.class, 
                () -> new Contact("SantaLong123", "Santa", "Claus", "1234567890", "North Pole"), 
                "Contact ID should not exceed 10 characters"),

            // First Name validation
            () -> assertThrows(IllegalArgumentException.class, 
                () -> new Contact("Santa123", null, "Claus", "1234567890", "North Pole"), 
                "First name should not be null"),
            () -> assertThrows(IllegalArgumentException.class, 
                () -> new Contact("Santa123", "SantaLongName", "Claus", "1234567890", "North Pole"), 
                "First name should not exceed 10 characters"),

            // Last Name validation
            () -> assertThrows(IllegalArgumentException.class, 
                () -> new Contact("Santa123", "Santa", null, "1234567890", "North Pole"), 
                "Last name should not be null"),
            () -> assertThrows(IllegalArgumentException.class, 
                () -> new Contact("Santa123", "Santa", "ClausLongName", "1234567890", "North Pole"), 
                "Last name should not exceed 10 characters"),

            // Phone validation
            () -> assertThrows(IllegalArgumentException.class, 
                () -> new Contact("Santa123", "Santa", "Claus", null, "North Pole"), 
                "Phone number should not be null"),
            () -> assertThrows(IllegalArgumentException.class, 
                () -> new Contact("Santa123", "Santa", "Claus", "12345", "North Pole"), 
                "Phone number must be exactly 10 digits"),
            () -> assertThrows(IllegalArgumentException.class, 
                () -> new Contact("Santa123", "Santa", "Claus", "12345678901", "North Pole"), 
                "Phone number must be exactly 10 digits"),
            () -> assertThrows(IllegalArgumentException.class, 
                () -> new Contact("Santa123", "Santa", "Claus", "12345abcde", "North Pole"), 
                "Phone number must contain only digits"),

            // Address validation
            () -> assertThrows(IllegalArgumentException.class, 
                () -> new Contact("Santa123", "Santa", "Claus", "1234567890", null), 
                "Address should not be null"),
            () -> assertThrows(IllegalArgumentException.class, 
                () -> new Contact("Santa123", "Santa", "Claus", "1234567890", 
                                  "123 North Pole, Santa's Long Address"), 
                "Address should not exceed 30 characters")
        );
    }

    @Test
    @DisplayName("Test updating a contact's fields to invalid values")
    public void testInvalidContactUpdates() {
        Contact contact = new Contact("Santa123", "Santa", "Claus", "1234567890", "North Pole");

        assertAll(
            // Invalid first name updates
            () -> assertThrows(IllegalArgumentException.class, 
                () -> contact.setFirstName(null), "First name should not be null"),
            () -> assertThrows(IllegalArgumentException.class, 
                () -> contact.setFirstName("SantaLongName"), "First name should not exceed 10 characters"),

            // Invalid last name updates
            () -> assertThrows(IllegalArgumentException.class, 
                () -> contact.setLastName(null), "Last name should not be null"),
            () -> assertThrows(IllegalArgumentException.class, 
                () -> contact.setLastName("ClausLongName"), "Last name should not exceed 10 characters"),

            // Invalid phone updates
            () -> assertThrows(IllegalArgumentException.class, 
                () -> contact.setPhone(null), "Phone number should not be null"),
            () -> assertThrows(IllegalArgumentException.class, 
                () -> contact.setPhone("12345"), "Phone number must be exactly 10 digits"),
            () -> assertThrows(IllegalArgumentException.class, 
                () -> contact.setPhone("12345678901"), "Phone number must be exactly 10 digits"),

            // Invalid address updates
            () -> assertThrows(IllegalArgumentException.class, 
                () -> contact.setAddress(null), "Address should not be null"),
            () -> assertThrows(IllegalArgumentException.class, 
                () -> contact.setAddress("123 North Pole, Santa's Long Address"), 
                "Address should not exceed 30 characters")
        );
    }
}
