package security;

import java.io.File;
import java.util.ArrayList;


public class SecurityAppRunner {
    public static void main(String[] args) {

        File testFile = new File("examples/Testfile.java");
        ArrayList<SecurityRule> rules = new ArrayList<>();
        
        SecurityRule selectedRule = new SecurityRule(
            "SQL Injection", 
            "Detects SQL injection vulnerabilities", 
            5, 
            ".*(SELECT).*"
        );
        SecurityRule insertRule = new SecurityRule(
            "SQL Injection", 
            "Detects SQL injection vulnerabilities", 
            5, 
            ".*(INSERT).*"
        );
        SecurityRule updateRule = new SecurityRule(
            "SQL Injection", 
            "Detects SQL injection vulnerabilities", 
            5, 
            ".*(UPDATE).*"
        );
        SecurityRule deleteRule = new SecurityRule(
            "SQL Injection", 
            "Detects SQL injection vulnerabilities", 
            5, 
            ".*(DELETE).*"
        );
        rules.add(selectedRule);
        rules.add(insertRule);
        rules.add(updateRule);
        rules.add(deleteRule);
        SecurityApp app = new SecurityApp(rules);

        String fileType = SecurityApp.detectFileType(testFile.getName(), testFile);
        if (!fileType.equals("Unknown")) {
            app.scanFile(testFile);
        } else {
            System.out.println("Cannot scan file: Unknown type");
        }
        System.out.println("Final risk level: " + app.getRiskLevel());
    }
}
