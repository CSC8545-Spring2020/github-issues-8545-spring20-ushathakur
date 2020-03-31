package edu.studio.issue;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.jupiter.api.Test;

class IssueExporterTest {
    IssueExporter ieobj = new IssueExporter();
    
    @SuppressWarnings("deprecation")
    @Test
    void givenInvalidcredentialsThenPromtUserToEnterValidCred() {
      
        String[] a = {"someone", "something"};
        assertEquals(a, ieobj.validateCredentials(a));
       
    }


@Test
void testJsonExporterWhenValidCredentials() throws IOException {
    String expectedJson = Files.readString(Paths.get("C:\\Users\\thaku\\Documents\\sample-output.txt"));
  //  ieobj.jsonExporter();
    UniRestDemo y = new UniRestDemo();
    Login login = new Login();
    login.userName = y.userName;
    login.password = y.password;
    assertEquals(expectedJson, ieobj.jsonExporter(login));
}

@Test
void testIssueParserReturnsIssueObjectsGivenJsonString() throws IOException {
    IssueParser ipobj = new IssueParser();
    String sampleJson = Files.readString(
            Paths.get("C:\\Users\\thaku\\Documents\\sample-output.txt"));
    List<Issue> mainIssues = ipobj.issueParser(sampleJson);

    //System.out.println(ipobj.issues);
    assertEquals(mainIssues, ieobj.obtainIssueObjects() );
   
}
@Test
void testIssueExporterExportsToOutputFile() {
    assertTrue(ieobj.outputFile.length()!=0);
}
}
