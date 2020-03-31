package edu.studio.issue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import kong.unirest.Unirest;

public class GitHubRestClient {
    String jsonresponse;
    public final String URL = "https://api.github.com/repos/CSC8545-Spring2020/github-issues-8545-spring20-ushathakur/issues?state=all";

 public String authorizeGitHubCredentialsAndExtractJSon(String[] args) throws FileNotFoundException, NullPointerException {
      
          jsonresponse = Unirest.get(URL).basicAuth(args[0],args[1]).asString().getBody();
     return jsonresponse;
 }
}
