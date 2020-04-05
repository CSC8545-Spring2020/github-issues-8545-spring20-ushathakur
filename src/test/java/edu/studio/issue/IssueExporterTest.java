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
    IssueExporter exporter = new IssueExporter();
    Login login = new Login();

    @Test
    void givenInvalidcredentialsThenPromptUserToEnterValidCred() {

        String[] a = { "someone", "something" };
        assertEquals(a, exporter.validateCredentials(a));

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

        assertEquals(expectedJson, exporter.jsonExporter(login));
    }

    @Test
    void testIssueParserReturnsIssueObjectsGivenJsonString()
            throws IOException {
        IssueParser parser = new IssueParser();
        String sampleJson = Files.readString(
                Paths.get("C:\\Users\\thaku\\Documents\\sample-output.txt"));
        List<Issue> mainIssues = parser.issueParser(sampleJson);
        assertEquals(mainIssues, exporter.obtainIssueObjects(sampleJson));

    }

    @Test
    void testIssueExporterExportsOrderedListToOutputFile() {
        assertTrue((exporter.file.length()) != 0); // before executing the program

    }
}
