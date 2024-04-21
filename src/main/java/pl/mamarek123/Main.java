package pl.mamarek123;

import pl.mamarek123.AwsIAMRolePolicyJsonChecker.FileVerifier;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FileVerifier fileVerifier = new FileVerifier();
        System.out.println("Trying to verify AWSIAMRolePolicy JSON with a single asterisk");
        boolean verificationResult = false;
        try {
            verificationResult = fileVerifier.verify("src/main/resources/ExampleRolePolicy.json");
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
        System.out.println("Expecting:\n" +
                "false\n" +
                "Actual value: \n" +
                verificationResult);
    }
}