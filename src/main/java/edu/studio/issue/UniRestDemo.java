package edu.studio.issue;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import kong.unirest.Unirest;
public class UniRestDemo {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = null;
        try {

            sc = new Scanner(new File("C:\\Users\\thaku\\Documents\\cred.txt"));
            String line = null;
            while (sc.hasNext()) {
                line = sc.nextLine();
            }
            String s[] = line.split(" ", 2);
            String username = s[0];
            String password = s[1];
            String responseBody = Unirest.get(
                    "https://api.github.com/repos/CSC8545-Spring2020/github-issues-8545-spring20-ushathakur/issues")
                    .basicAuth(username, password).asString().getBody();
            System.out.println(responseBody);
        }
        catch (FileNotFoundException fnfe) {
            System.out.println("no such file found");
            fnfe.printStackTrace();
        }
        finally {

            sc.close();
        }
    }
}
