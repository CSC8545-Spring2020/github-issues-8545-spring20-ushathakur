package edu.studio.issue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class IssueExporterTest   {
    IssueExporter exporter = new IssueExporter();
    Login login = new Login();

    @Test
    @Order(1)
    void givenInvalidcredentialsThenPromptUserToEnterValidCred() {

        String[] a = { "someone"};
        assertEquals(a, exporter.validateCredentials(a));
   
       
    }
    
    

    @Test
    @Order(2)
    void testJsonExporterWhenValidCredentials() throws IOException {
        String expectedJson = Files.readString(
                Paths.get("C:\\Users\\thaku\\Documents\\sample-output.txt"));
        Scanner sc = new Scanner(
                new File("C:\\Users\\thaku\\Documents\\cred.txt"));
        String line = null;
        while (sc.hasNext()) {
            line = sc.nextLine();
        }
        sc.close();
        String s[] = line.split(" ", 2);
        String userName = s[0];
        String password = s[1];
        Login login = new Login();
        login.userName = userName;
        login.password = password;

        assertEquals(expectedJson, exporter.jsonExporter(login));
    }

    @Test
    @Order(3)
    void testIssueParserReturnsIssueObjectsGivenJsonString()
            throws IOException {
        IssueParser parser = new IssueParser();
        String sampleJson = Files.readString(
                Paths.get("C:\\Users\\thaku\\Documents\\sample-output.txt"));
        List<Issue> mainIssues = parser.issueParser(sampleJson);
        assertEquals(mainIssues, exporter.obtainIssueObjects(sampleJson));
      

    }

    @Test
    @Order(4)
    void testIssueExporterExportsOrderedListToOutputFile() {
        assertTrue((exporter.file.length()) != 0); 

    }
//    @Test //running this test will terminate the remaining tests
//    @Order(5)
//    void givenWrongCredentialsButCorrectNumberOfArgumentsAsInput() throws FileNotFoundException, NullPointerException {
//        
//        Login login1 = new Login();
//        login1.userName = "something";
//        login1.password = "somethingelse";
//        assertEquals("{\"message\":\"Bad credentials\",\"documentation_url\":\"https://developer.github.com/v3\"}", exporter.jsonExporter(login1));
//    }
}
