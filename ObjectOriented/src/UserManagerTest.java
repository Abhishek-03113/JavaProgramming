import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserManagerTest {
    private UserManager userManager;

    @BeforeEach
    void setUp() {
        userManager = new UserManager();
    }

    @Test
    void testCreateUser() {
        userManager.CreateUser("alice", "Alice Wonderland", 28, 11111, 5000);
        List<User> users = userManager.getUsers();

        assertEquals(1, users.size());
        User user = users.getFirst();
        assertEquals("alice", user.username);
        assertEquals("Alice Wonderland", user.name);
        assertEquals(28, user.age);
        assertEquals(11111, user.getAccount_no());
        assertEquals(5000, user.getAccount_balance());
    }

    @Test
    void testDeleteUser() {
        userManager.CreateUser("bob", "Bob Builder", 35, 22222, 7000);
        userManager.CreateUser("charlie", "Charlie Chaplin", 40, 33333, 9000);

        assertEquals(2, userManager.getUsers().size());

        userManager.DeleteUser("bob");

        List<User> users = userManager.getUsers();
        assertEquals(1, users.size());
        assertEquals("charlie", users.getFirst().username);
    }

    @Test
    void testDeleteNonExistentUser() {
        userManager.CreateUser("dave", "Dave Developer", 29, 44444, 8000);

        assertEquals(1, userManager.getUsers().size());

        userManager.DeleteUser("nonexistent");  // Should do nothing

        assertEquals(1, userManager.getUsers().size());
    }

    @Test
    void testMultipleUsers() {
        userManager.CreateUser("alice", "Alice Wonderland", 28, 11111, 5000);
        userManager.CreateUser("bob", "Bob Builder", 35, 22222, 7000);
        userManager.CreateUser("charlie", "Charlie Chaplin", 40, 33333, 9000);

        List<User> users = userManager.getUsers();
        assertEquals(3, users.size());

        // Verify data of last user
        User lastUser = users.get(2);
        assertEquals("charlie", lastUser.username);
        assertEquals(33333, lastUser.getAccount_no());
        assertEquals(9000, lastUser.getAccount_balance());
    }
}
