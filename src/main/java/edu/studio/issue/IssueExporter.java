package edu.studio.issue;

import java.io.File;
import java.util.List;

public class IssueExporter {

    public static void main(String[] args) {
        commandLineInputForCredentials(args);

    }
    private List<Issue> orderedIssues;
    private String extractedJson;
    public File outputFile;
   
    
public String[] validateCredentials(String[] args) {
        if((args == null) || (args.length==0)) {
            System.out.println("bad credentials, please enter your credentials again and re-run the program");
            //System.exit(0);
           // return "bad credentials, please enter your credentials again and re-run the program";
        }
        else
            return args;
            //System.out.println(login.userName+login.password);
        return args;
      }
public Login commandLineInputForCredentials(String[] args) {
   Login login = new Login();
    login.userName = args[0];
    login.password = args[1];
    return login;
}


public String jsonExporter(Login login) {
    GitHubRestClient restClient = new GitHubRestClient();
    restClient.authorizeGitHubCredentialsAndExtractJSon(args);
    return extractedJson;
}
public List<Issue> obtainIssueObjects(String extractedJson) {
    // TODO Auto-generated method stub
    return orderedIssues;
}

}
