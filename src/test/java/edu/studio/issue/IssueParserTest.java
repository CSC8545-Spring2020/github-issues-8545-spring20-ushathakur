package edu.studio.issue;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class IssueParserTest {
   // @BeforeAll
  //  void setUp() {
      IssueParser ipobj = new IssueParser();
      GitHubRestClient ghrcObj = new GitHubRestClient();
    //}

    @Test
    void testIssueParserGivenJson() throws IOException {
       String sampleJson = Files.readString(Paths.get("C:\\Users\\thaku\\Documents\\sample-output.txt"));
        List<Issue> mainIssues = ipobj.issueParser(sampleJson);
        assertEquals(3, mainIssues.size() );
        
       //assertEquals(randomissue, mainIssues.get(0));
        
       
    }

}
