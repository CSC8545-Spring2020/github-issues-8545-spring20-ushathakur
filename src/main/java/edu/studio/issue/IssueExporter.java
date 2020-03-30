package edu.studio.issue;

import java.io.File;
import java.util.List;

public class IssueExporter {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    private List<Issue> orderedIssues;
    private String extractedJson;
    public File outputFile;
public void commandLineInputForCredentials(String[] args) {
   Login login = new Login();
    login.userName = args[0];
    login.password = args[1];
}
public Object validateCredentials(String string, String string2) {
    // TODO Auto-generated method stub
    return null;
}

public String jsonExporter(Login login) {
    // TODO Auto-generated method stub
    return extractedJson;
}
public List<Issue> obtainIssueObjects() {
    // TODO Auto-generated method stub
    return orderedIssues;
}

}
