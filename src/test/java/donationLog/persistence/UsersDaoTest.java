package donationLog.persistence;

import donationLog.entity.Users;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import donationLog.util.Database;

public class UsersDaoTest {

    // Instantiate new DAO
    DAO usersDAO;
    @Before
    public void setup() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        usersDAO = new DAO();
    }

    @Test
    public void testGetByIdSuccess() {
        // Assuming getById method exists in DonationDAO
        Users retrievedUser = usersDAO.getUserById(1);
        String expctedUserName = "dwellons";
        assertNotNull(retrievedUser);

        // Update the expected donor name based on the actual donor name you expect
        assertTrue(expctedUserName.equals(retrievedUser.getUserName()));
    }

    @Test
    public void updateSuccess() {
        // get a record out of the database
        Users userToUpdate = usersDAO.getUserById(1);
        String expectedFirstName = "Nirad";
        // change the name on that user
        userToUpdate.setFirstName("Nirad");

        // do the update
        usersDAO.updateUser(userToUpdate);

        // retrieve the user and check that the name change worked
        Users actualDonation = usersDAO.getUserById(1);

        // do comparison
        assertTrue(expectedFirstName.equals(actualDonation.getFirstName()));
    }

    @Test
    public void testInsertSuccess() {
        // insert a test user
        Users newUser = new Users(0, "test", "test", "test", "test");
        int insertedUserId = usersDAO.insertUser(newUser);
        String expectedUser = "test";
        assertNotEquals(0, insertedUserId);

        Users insertedUser = usersDAO.getUserById(insertedUserId);

        // Using equals();
        assertTrue(expectedUser.equals(insertedUser.getFirstName()));

    }

    @Test
    public void testDelete() {
        // get the user with id of nine, delete it
        usersDAO.deleteUser(usersDAO.getUserById(6));
        // if delete is working, shouldn't get a user back
        assertNull(usersDAO.getUserById(6));

        // Deletes previous test user that was inserted
    }

    @Test
    public void getAll() {
        // gets all users
        int numberOfUsers = 5;
        List<Users> users = usersDAO.getAllUsers();
        assertEquals(5, users.size());
    }

    @Test
    public void testGetByPropertyEqual() {
        // gets user with property exactly like "dwellons"
        List<Users> users = usersDAO.getUserByPropertyLike("userName", "dwellons");
        assertEquals(2, users.size());
        assertEquals(1, users.get(0).getID());

    }

    @Test
    public void testGetByPropertyLike() {
        // gets users with property like "nirad"
        usersDAO = new DAO();
        List<Users> users = usersDAO.getUserByPropertyLike("firstName", "Nirad");
        assertEquals(2, users.size());
    }
}