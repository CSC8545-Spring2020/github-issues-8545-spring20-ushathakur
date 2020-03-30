package edu.studio.issue;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IssueTest {
    Issue issue1= new Issue();
    Issue issue2 = new Issue();
    @Test
    void testGettersAndSettersGivenState() {
        issue1.setState("open");
        assertEquals("open", issue1.getState());
    }
    @Test
    void testGettersAndSettersGivenNumber() {
        issue1.setNumber(3);
        assertEquals(3, issue1.getNumber());
    }
    @Test
    void testGettersAndSettersGivenTitle() {
        issue1.setTitle("this is a bug");
        issue1.setTitle("this is a bug");
        assertEquals("this is a bug", issue1.getTitle());
    }
    @Test
    void testEqualsWhenSameInternalId() {
     
       issue1.setId(12345);
       issue2.setId(12345);
       assertTrue(issue1.equals(issue2));
    }
    @Test
    void testCompareToWhenDifferentInternalID() {
        issue1.setId(12345);
        
        issue2.setId(12300);
        assertEquals(1, issue1.compareTo(issue2));
    }

    @Test
    void testHashcodeGivenDifferentAttributes() {
        issue1.setState("open");
        issue1.setNumber(3);
        assertEquals(issue1.hashCode(),issue1.hashCode());
    }

@Test
void testToStringWhenInputIsNull() {
    issue1.setNumber(3);
    issue1.setId(0);
    issue1.setState(null);
    issue1.setClosedAt(null);
    issue1.setCreatedAt(null);
    issue1.setBody(null);
    issue1.setTitle(null);
    
   assertEquals("Issue [id=0, number=3, state=null, title=null, body=null, createdAt=null, closedAt=null]", issue1.toString());
}
}