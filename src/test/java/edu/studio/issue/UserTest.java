package edu.studio.issue;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.Scanner;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class UserTest {
  
@Test
public void testProp() {
   User user1= new User();
user1.setLogin("somename");
assertEquals("somename", user1.getLogin());
}
 
    @Test
   public void testEquals() {
      User user1 = new User();
        user1.setLogin("somename");
        User user2 = new User();
        user2.setLogin("somename");
        assertTrue(user2.equals(user1));
        assertEquals(user1.hashCode(),user2.hashCode());
        
    
    }
@Test
public void testHashCode() {
    User user1 = new User();
    user1.setLogin("somename");
    user1.setId(4444);
    assertEquals(user1.hashCode(), user1.hashCode());
}
@Test
public void testComparedToWhenSameNameAndInternalID() {
    User user1 = new User();
    User user2 = new User();
    user1.setLogin("somename");
    user2.setLogin("somename");
    user1.setId(44);
    user2.setId(44);

    assertEquals(0,user1.compareTo(user2));
    
}

}
