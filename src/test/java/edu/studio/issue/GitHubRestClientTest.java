package edu.studio.issue;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import kong.unirest.Unirest;

class GitHubRestClientTest {
    GitHubRestClient xyz = new GitHubRestClient();
    @Test
    void testGivenJsonFileWhenProvidedCredentials() throws IOException {
      
        Scanner  sc = new Scanner(new File("C:\\Users\\thaku\\Documents\\cred.txt"));
        String line = null;
        while (sc.hasNext()) {
            line = sc.nextLine();
        }
        String s[] = line.split(" ", 2);
        String userName = s[0];
        String password = s[1];
        GitHubRestClient GitHubclient = new GitHubRestClient();
        String expectedJson = Files.readString(Paths.get("C:\\Users\\thaku\\Documents\\sample-output.txt"));
        String actualJson = GitHubclient.authorizeGitHubCredentialsAndExtractJSon(s);
                assertEquals(expectedJson, actualJson);
        
       
    }

}
