package edu.studio.issue;


import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class IssueParser {
    //public List<Issue> issues;
    public static void main(String[] args) throws IOException {
        IssueParser a = new IssueParser();
        String sampleJson = Files.readString(Paths.get("C:\\Users\\thaku\\Documents\\sample-output.txt"));
        List<Issue> returnedIssues=  a.issueParser(sampleJson);
       System.out.println(returnedIssues);
    }

    public List<Issue> issueParser(String jsonContent) {
        Gson gson = new GsonBuilder() 
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES) 
                .create(); 
        List<Issue> issues = new ArrayList<Issue>(); 
        Type collectionType = new TypeToken<List<Issue>>(){}.getType();
       issues = gson.fromJson(jsonContent, collectionType); 
       Collections.sort(issues);
     
        return issues;
    }


}
