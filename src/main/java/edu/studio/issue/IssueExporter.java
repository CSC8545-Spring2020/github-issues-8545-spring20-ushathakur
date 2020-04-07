package edu.studio.issue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import jdk.jfr.StackTrace;
import kong.unirest.Unirest;

public class IssueExporter {
    private List<Issue> orderedIssues;
    private String extractedJson;
    public File outputFile;
    public File file = new File("src/main/resources/actual-issues.txt");

    public static void main(String[] args) throws NullPointerException,
            IOException, ArrayIndexOutOfBoundsException {
        try {
            IssueExporter issueExporter = new IssueExporter();
            issueExporter.takeInputHitLiveUrlExportIssues(args);
        }

        catch (NullPointerException | IOException
                | ArrayIndexOutOfBoundsException npe) {
            System.out.println(npe);
            System.out.println(
                    "bad credentials, please enter your credentials again and re-run the program");
            
        }
    }

    public void takeInputHitLiveUrlExportIssues(String[] args)
            throws NullPointerException, IOException {
        try {
            args = validateCredentials(args);
            Login login = commandLineInputForCredentials(args);
            extractedJson = jsonExporter(login);
            orderedIssues = obtainIssueObjects(extractedJson);
            exportOrderedIssuesToAFile(orderedIssues);
        }
        catch (NullPointerException | IOException npe) {
            System.out.println(npe);
            npe.printStackTrace();

        }

    }

    public String[] validateCredentials(String[] args) {
        if ((args == null) || (args.length != 2)) {
            System.out.println(
                    "bad credentials, please enter your credentials again and re-run the program");
            
        }
        if (((args.length) == 2) && (args != null)) {
            return args;
        }

        else {
            return args;
        }
    }

    public Login commandLineInputForCredentials(String[] args) {
        Login login = new Login();
        login.userName = args[0];
        login.password = args[1];
        return login;
    }

    public String jsonExporter(Login login)
            throws FileNotFoundException, NullPointerException {
        GitHubRestClient restClient = new GitHubRestClient();
        extractedJson = restClient
                .authorizeGitHubCredentialsAndExtractJson(login);
       
       if(extractedJson.startsWith("{\"message\":\"Bad credentials")) {
            System.out.println(extractedJson);
            System.out.println("enter correct credentials and re-run the program");
            System.exit(0);
        }
        return extractedJson;
    }

    public List<Issue> obtainIssueObjects(String extractedJson){
        IssueParser parser = new IssueParser();
        orderedIssues = parser.issueParser(extractedJson);
        return orderedIssues;
    }

    public void exportOrderedIssuesToAFile(List<Issue> orderedIssues)
            throws IOException, ArrayIndexOutOfBoundsException {
        //ClassLoader classLoader = ;
        File file = new File ("actual-issues.txt");
        FileWriter writer = new FileWriter(file);
        int size = orderedIssues.size();
        System.out.println("number of issues:" +size);
        for (int i = 0; i < size; i++) {
            String getData = orderedIssues.get(i).toString();
            writer.write(getData);
            System.out.println(getData);
           
            
        }
        writer.close();
    }
}
