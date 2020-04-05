package edu.studio.issue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class IssueExporterTest {
    IssueExporter ieobj = new IssueExporter();
    Login login = new Login();

    @SuppressWarnings("deprecation")
    @Test
    void givenInvalidcredentialsThenPromtUserToEnterValidCred() {

        String[] a = { "someone", "something" };
        assertEquals(a, ieobj.validateCredentials(a));

    }

    @Test
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

        assertEquals(expectedJson, ieobj.jsonExporter(login));
    }

    @Test
    void testIssueParserReturnsIssueObjectsGivenJsonString()
            throws IOException {
        IssueParser ipobj = new IssueParser();
        String sampleJson = Files.readString(
                Paths.get("C:\\Users\\thaku\\Documents\\sample-output.txt"));
        List<Issue> mainIssues = ipobj.issueParser(sampleJson);
        assertEquals(mainIssues, ieobj.obtainIssueObjects(sampleJson));

    }

    @Test
    void testIssueExporterExportsOrderedListToOutputFile() {
        assertTrue((ieobj.file.length()) != 0); // before executing the program

    }
}
