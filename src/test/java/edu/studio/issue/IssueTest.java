package edu.studio.issue;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IssueTest {
    Issue issue1= new Issue();
    Issue issue2 = new Issue();
    @Test
    void testEqualsWhenSameInternalId() {
     
       issue1.setId(12345);
       
       issue2.setId(12345);
       assertTrue(issue1.equals(issue2));
    }
    @Test
    void testComparedToWhenDifferentInternalID() {
        issue1.setId(12345);
        
        issue2.setId(12300);
        assertEquals(0, issue1.compareTo(issue2));
    }

}
