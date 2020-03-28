package edu.studio.issue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import kong.unirest.Unirest;

public class UniRestDemo {
    Scanner sc1 = null;
    Scanner sc = null;
    String login, pass = null;
    public static File file;
    public String userName, password, responseBody;

    public static void main(String[] args)
            throws FileNotFoundException, NullPointerException {
        UniRestDemo x = new UniRestDemo();
        file = new File("C:\\Users\\thaku\\Documents\\cred.txt");
        x.auth(file);
        System.out.println(x.userName + " " + x.password);
        x.userInput();

    }

    public void auth(File in)
            throws FileNotFoundException, NullPointerException {

        try {

            sc = new Scanner(in);
            String line = null;
            while (sc.hasNext()) {
                line = sc.nextLine();
            }
            String s[] = line.split(" ", 2);
            this.userName = s[0];
            this.password = s[1];

        }
        catch (FileNotFoundException | NullPointerException npe) {
            System.out.println("no such file found");

            npe.printStackTrace();
        }
        finally {

            sc.close();
        }
    }

    public String userInputForCredentials() throws NullPointerException {

        try {
            sc1 = new Scanner(System.in);
            boolean valid = true;

            do {
                System.out.println("enter your git user ID:");

                String login = sc1.nextLine();
                System.out.println("enter your password:");
                String pass = sc1.nextLine();

                if (login.isEmpty()) {
                    System.out.println(
                            "bad credentials, please enter your credentials again");
                    valid = false;
                    String responseBody = Unirest.get(
                            "https://api.github.com/repos/CSC8545-Spring2020/github-issues-8545-spring20-ushathakur/issues")
                            .basicAuth(login, pass).asString().getBody();
                    System.out.println(responseBody);
                    return responseBody;
                }

            } while (!valid);

        }
        catch (NullPointerException npe) {
            System.out.println(
                    "bad credentials, please enter your credentials again");
            userInput();

            npe.printStackTrace();
        }
        finally {
            sc1.close();
        }
    }
}
