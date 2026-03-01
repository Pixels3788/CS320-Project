import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class ContactServiceTest {
	
	@Test
	void testAddContact() {
		ContactService service = new ContactService();
		Contact contact  = new Contact("001", "Jane", "Doe", "1234567890", "456 Elm Street");
		service.addContact(contact);
	}
	
	@Test
    void testAddDuplicateContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("001", "Jane", "Doe", "1234567890", "456 Elm Street");
        service.addContact(contact);

        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact);
        });
    }

    @Test
    void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("001", "Jane", "Doe", "1234567890", "456 Elm Street");
        service.addContact(contact);
        service.deleteContact("001");
    }

    @Test
    void testUpdateContactFields() {
        ContactService service = new ContactService();
        Contact contact = new Contact("001", "Jane", "Doe", "1234567890", "456 Elm Street");
        service.addContact(contact);

        service.updateFirstName("001", "Janet");
        service.updateLastName("001", "Smith");
        service.updatePhone("001", "0987654321");
        service.updateAddress("001", "789 Oak Avenue");

        assertEquals("Janet", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("0987654321", contact.getPhone());
        assertEquals("789 Oak Avenue", contact.getAddress());
    }

    @Test
    void testDeleteNonExistentContact() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("999");
        });
    }

    @Test
    void testUpdateNonExistentContact() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.updateFirstName("999", "Bob");
        });
    }
	
	

}
