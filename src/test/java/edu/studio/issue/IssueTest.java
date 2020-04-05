package edu.studio.issue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class IssueTest {
    Issue issue1 = new Issue();
    Issue issue2 = new Issue();
    Issue issue3 = new Issue();

    @Test
    void testGettersAndSettersGivenState() {
        issue1.setState("open");
        issue2.setState("");
        issue3.setState(null);
        assertEquals("open", issue1.getState());
        assertEquals("", issue2.getState());
        assertEquals(null, issue3.getState());
        assertFalse(issue3.equals(issue1));
    }

    @Test
    void testGettersAndSettersGivenNumber() {
        issue1.setNumber(3);
        issue2.setNumber(0);
        assertEquals(3, issue1.getNumber());
        assertFalse(issue1.equals(issue2));
    }

    @Test
    void testGettersAndSettersGivenTitle() {
        issue1.setTitle("this is a bug");
        issue2.setTitle("this is a bug");
        issue2.setTitle("othertitle");
        assertEquals("this is a bug", issue1.getTitle());
        //assertTrue(issue1.equals(issue2));
        assertFalse(issue3.equals(issue2));
        
    }

    @Test
    void testEqualsWhenSameInternalId() {

        issue1.setId(12345);
        issue2.setId(12345);
        issue3.setId(12344);
        
        assertEquals(12345, issue1.getId());
        assertTrue(issue1.equals(issue2));
        assertFalse(issue3.equals(issue2));
    }

    @Test
    void testCompareToWhenDifferentInternalID() {
        issue1.setId(12345);
        issue2.setId(12300);
        issue3.setId(12300);
        assertEquals(1, issue1.compareTo(issue2));
        assertEquals(0, issue3.compareTo(issue2));
        assertEquals(-1, issue3.compareTo(issue1));
    }

    @Test
    void testHashcodeGivenDifferentAttributes() {
        issue1.setState("open");
        issue1.setNumber(3);
        assertEquals(issue1.hashCode(), issue1.hashCode());
    }

    @Test
    void testToStringWhenInputIsNull() {
        issue1.setNumber(0);
        issue1.setId(0);
        issue1.setState(null);
        issue1.setClosedAt(null);
        issue1.setCreatedAt(null);
        issue1.setBody(null);
        issue1.setTitle(null);

        assertEquals(
                "Issue [id=0, number=0, state=null, title=null, body=null, createdAt=null, user=null, assignee=null, closedAt=null]",
                issue1.toString());
    }
    @Test
    void testGetBodyGivenSomeInput() {
        issue1.setBody("setting some fake info");
        assertEquals("setting some fake info", issue1.getBody());
        assertTrue((issue1.getBody())!=null);
    }
    
}