package edu.studio.issue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import kong.unirest.Unirest;

public class IssueExporter {
    private List<Issue> orderedIssues;
    private String extractedJson;
    public File outputFile;
    public File file = new File("src/main/resources/actual-issues.txt");

    public static void main(String[] args)
            throws NullPointerException, IOException {

        IssueExporter ref = new IssueExporter();
        ref.functionCalls(args);

    }

    public void functionCalls(String[] args)
            throws NullPointerException, IOException {
        try {
            args = validateCredentials(args);
            Login login = commandLineInputForCredentials(args);
            extractedJson = jsonExporter(login);
            orderedIssues = obtainIssueObjects(extractedJson);
            exportOrderedIssues(orderedIssues);
        }
        catch (NullPointerException | IOException npe) {
            System.out.println();

        }

    }

    public String[] validateCredentials(String[] args) {
        if ((args == null) || (args.length == 0)) {
            System.out.println(
                    "bad credentials, please enter your credentials again and re-run the program");
            // System.exit(0);
            // return "bad credentials, please enter your credentials again and
            // re-run the program";
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
        // final String URL =
        // "https://api.github.com/repos/CSC8545-Spring2020/github-issues-8545-spring20-ushathakur/issues?state=all";
        // String jsonresponse = Unirest.get(URL).basicAuth(login.userName,
        // login.password).asString().getBody();
        // return jsonresponse;
        // this.login = login;
        extractedJson = restClient
                .authorizeGitHubCredentialsAndExtractJSon(login);
        //System.out.println(extractedJson);
        return extractedJson;
    }

    public List<Issue> obtainIssueObjects(String extractedJson) {
        IssueParser parser = new IssueParser();
        orderedIssues = parser.issueParser(extractedJson);
        return orderedIssues;
    }

    public void exportOrderedIssues(List<Issue> orderedIssues)
            throws IOException {
        File file = new File("src/main/resources/actual-issues.txt");
        FileWriter writer = new FileWriter(file);
        int size = orderedIssues.size();
        System.out.println(size);
        for (int i = 0; i < size; i++) {
            String getData = orderedIssues.get(i).toString();
            writer.write(getData);
            System.out.println(getData);
        }
        writer.close();
    }
}
