package edu.studio.issue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import kong.unirest.Unirest;

public class GitHubRestClient {
    String jsonresponse;
    public final String URL = "https://api.github.com/repos/CSC8545-Spring2020/github-issues-8545-spring20-ushathakur/issues?state=all";
public static void main(String [] args) throws FileNotFoundException, NullPointerException {
  
   GitHubRestClient def = new GitHubRestClient();
 def.auth();
}
// public String getAllIssuesFromUrl(UniRestDemo abc) {
//     String jsonresponse = Unirest.get(URL).basicAuth(consoleinput, consoleinput).asString().getBody();
//     System.out.println(jsonresponse);
//     return jsonresponse;
// }
 
 public String auth() throws FileNotFoundException, NullPointerException {

     try {

       Scanner  sc = new Scanner(new File("C:\\Users\\thaku\\Documents\\cred.txt"));
         String line = null;
         while (sc.hasNext()) {
             line = sc.nextLine();
         }
         String s[] = line.split(" ", 2);
         String userName = s[0];
         String password = s[1];
          jsonresponse = Unirest.get(URL).basicAuth(userName,password).asString().getBody();
         System.out.println(jsonresponse);
        
     }
     catch (FileNotFoundException | NullPointerException npe) {
         System.out.println("no such file found");
         
         npe.printStackTrace();
     }
     return jsonresponse;
 }
}
