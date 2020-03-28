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

    @Test
    void testGivenJsonFileWhenProvidedCredentials() throws IOException {
      
      
        String URL = "https://api.github.com/repos/CSC8545-Spring2020/github-issues-8545-spring20-ushathakur/issues";
        GitHubRestClient GitHubclient = new GitHubRestClient();
        UniRestDemo urdobj = new UniRestDemo();
        String expectedJson = Files.readString(Paths.get("C:\\Users\\thaku\\Documents\\sample-output.txt"));
        String actualJson = GitHubclient.auth();
                assertEquals(expectedJson, actualJson);
        
       
    }

}
