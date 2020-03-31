package edu.studio.issue;


import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class IssueExporterTest {
    IssueExporter ieobj = new IssueExporter();
    Login login = new Login();
    
    @SuppressWarnings("deprecation")
    @Test
    void givenInvalidcredentialsThenPromtUserToEnterValidCred() {
      
        String[] a = {"someone", "something"};
        Assert.assertEquals(a, ieobj.validateCredentials(a));
       
    }

@Test
void testJsonExporterWhenValidCredentials() throws IOException {
    String expectedJson = Files.readString(Paths.get("C:\\Users\\thaku\\Documents\\sample-output.txt"));
  //  ieobj.jsonExporter();

    Scanner  sc = new Scanner(new File("C:\\Users\\thaku\\Documents\\cred.txt"));
    String line = null;
    while (sc.hasNext()) {
        line = sc.nextLine();
    }
    String s[] = line.split(" ", 2);
    String userName = s[0];
    String password = s[1];
    Login login = new Login();
    login.userName = userName;
    login.password = password;

    Assert.assertEquals(expectedJson, ieobj.jsonExporter(login));
}

@Test
void testIssueParserReturnsIssueObjectsGivenJsonString() throws IOException {
    IssueParser ipobj = new IssueParser();
    String sampleJson = Files.readString(
            Paths.get("C:\\Users\\thaku\\Documents\\sample-output.txt"));
    List<Issue> mainIssues = ipobj.issueParser(sampleJson);
    Assert.assertEquals(mainIssues, ieobj.obtainIssueObjects(sampleJson));
   
}
@Test
void testIssueExporterExportsToOutputFile() {
    assertTrue(ieobj.outputFile.length()!=0);
}
}
