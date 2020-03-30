package edu.studio.issue;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

class IssueExporterTest {
    IssueExporter ieobj = new IssueExporter();
    
    @Test
    void givenInvalidcredentialsThenPromtUserToEnterValidCred() {
        IssueExporter ieobj = new IssueExporter();
        assertEquals("bad credentials, please enter your credentials again and re-run the program", ieobj.validateCredentials("",""));
       
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
void testIssueParserReturnsIssueObjectsGivenJsonString() {
    IssueParser ipobj = new IssueParser();
    assertEquals(ipobj.issues, ieobj.obtainIssueObjects() );
   
}
@Test
void testIssueExporterExportsToOutputFile() {
    assertTrue(ieobj.outputFile.length()!=0);
}
}
