package edu.studio.issue;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    public void testGettersAndSettersForUser() {
        User user1 = new User();
        user1.setLogin("somename");
        user1.setUser("someuser");
        user1.setAssignee("someassignee");
        assertEquals("somename", user1.getLogin());
        assertEquals("someuser", user1.getUser());
        assertEquals("someassignee", user1.getAssignee());
    }

    @Test
    public void testEquals() {
        User user1 = new User();
        user1.setLogin("somename");
        User user2 = new User();
        user2.setLogin("somename");
        assertTrue(user2.equals(user1));
      

    }

    @Test
    public void testHashCode() {
        User user1 = new User();
        user1.setId(4444);
        user1.setLogin("somename");
        User user2 = new User();
        user2.setId(4444);
        user2.setLogin("somename");
        assertEquals(user1.hashCode(), user1.hashCode());        
        assertEquals(user1.hashCode(), user2.hashCode());
    }

    @Test
    public void testComparedToWhenSameNameAndInternalID() {
        User user1 = new User();
        User user2 = new User();
        user1.setLogin("somename");
        user2.setLogin("somename");
        user1.setId(44);
        user2.setId(44);

        assertEquals(0, user1.compareTo(user2));

    }

}
