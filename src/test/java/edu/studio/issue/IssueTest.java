package edu.studio.issue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IssueTest {

    @Test
    void testEqualsWhenSameInternalId() {
       Issue issue1= new Issue();
       issue1.setId(12345);
       Issue issue2 = new Issue();
       issue2.setId(12345);
       assertEquals(issue1.equals(issue2));
    }

}
