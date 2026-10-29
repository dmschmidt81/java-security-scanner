
package security;

import java.io.File;
import java.util.ArrayList;

public class SecurityAppRunner 
{

    public static void main(String[] args) 
    {

        File testFile = new File("examples/Testfile.java");

        ArrayList<SecurityRule> rules = new ArrayList<>();

        String[] sqlKeywords = {
            "SELECT", "INSERT", "UPDATE", "DELETE"
        };

        for (String keyword : sqlKeywords) 
        {
            SecurityRule rule = new SecurityRule(
                "SQL Keyword: " + keyword,
                "Detects the SQL keyword " + keyword,
                0,
                ".*(" + keyword + ").*"
            );

            rules.add(rule);
        }

        SecurityApp app = new SecurityApp(rules);

        String fileType =
            SecurityApp.detectFileType(testFile.getName());

        System.out.println("File type: " + fileType);

        if (!fileType.equals("Unknown")) 
        {
            app.scanFile(testFile);
        }
        else 
        {
            System.out.println(
                "Cannot scan file: Unknown type"
            );
        }

        System.out.println(
            "Final risk level: " + app.getRiskLevel()
        );
    }
}

