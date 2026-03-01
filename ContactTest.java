import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class ContactTest {
	
	
	@Test
	void testValidContactCreation() {
		Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main Street");
		assertEquals("12345", contact.getContactId());
		assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main Street", contact.getAddress());
	}
	@Test
	void testInvalidContactId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Main Street");
        });
    }

    @Test
    void testInvalidPhone() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "12345", "123 Main Street");
        });
    }

    @Test
    void testInvalidAddressLength() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "1234567890",
                    "This address is definitely more than thirty characters long");
        });
    }

    @Test
    void testInvalidFirstName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", null, "Doe", "1234567890", "123 Main Street");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "NameTooLongHere", "Doe", "1234567890", "123 Main Street");
        });
    }

    @Test
    void testInvalidLastName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", null, "1234567890", "123 Main Street");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "LastNameTooLong", "1234567890", "123 Main Street");
        });
    }

    @Test
    void testSettersValidation() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main Street");

        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName(null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName(null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("123");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress("This address is definitely more than thirty characters long");
        });
    }

}
