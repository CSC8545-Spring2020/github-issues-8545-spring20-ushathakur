package edu.studio.issue;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class IssueParserTest {
    // @BeforeAll
    // void setUp() {
    IssueParser ipobj = new IssueParser();
    GitHubRestClient ghrcObj = new GitHubRestClient();

    // }

    @Test
    void testIssueParserGivenJson() throws IOException {
        String sampleJson = Files.readString(
                Paths.get("C:\\Users\\thaku\\Documents\\sample-output.txt"));
        List<Issue> mainIssues = ipobj.issueParser(sampleJson);
        assertEquals(4, mainIssues.size());
        Issue issue1 = mainIssues.get(0);

        assertEquals("randomissue", issue1.getTitle());
    }

    // Collections.sort(mainIssues);
    // System.out.println(mainIssues);
    @Test
    void testOrderGivenStatus() throws IOException {
        String sampleJson = Files.readString(
                Paths.get("C:\\Users\\thaku\\Documents\\sample-output.txt"));
        List<Issue> mainIssues = ipobj.issueParser(sampleJson);
        Issue issue4 = mainIssues.get(3);
        assertEquals("closed", issue4.getState());

    }

}
