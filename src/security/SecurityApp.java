
package security;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class SecurityApp 
{

    private int riskLevel;
    private ArrayList<SecurityRule> securityRules;

    public SecurityApp(ArrayList<SecurityRule> securityRules) 
    {
        riskLevel = 0;
        this.securityRules = new ArrayList<>(securityRules);
    }

    public static String detectFileType(String fileName) 
    {
        int dotIndex = fileName.lastIndexOf(".");

        if (dotIndex == -1) 
        {
            return "Unknown";
        }

        String fileExtension = fileName.substring(dotIndex + 1);

        if ("java".equals(fileExtension)) 
        {
            return "Java";
        }
        else if ("js".equals(fileExtension)) 
        {
            return "JavaScript";
        }
        else if ("py".equals(fileExtension)) 
        {
            return "Python";
        }
        else if ("txt".equals(fileExtension)) 
        {
            return "Text";
        }
        else 
        {
            return "Unknown";
        }
    }

    public void scanFile(File file) 
    {
        riskLevel = 0;

        try (Scanner input = new Scanner(file)) 
        {
            while (input.hasNextLine()) 
            {
                String line = input.nextLine();

                for (SecurityRule rule : securityRules) 
                {
                    String pattern = rule.getPattern();

                    if (line.matches(pattern)) 
                    {
                        System.out.println(
                            "Potential match: " + rule.getRuleName()
                        );
                        riskLevel += rule.getRiskWeight();
                    }
                }
            }
        }
        catch (FileNotFoundException e) 
        {
            System.err.println(
                "File not found: " + e.getMessage()
            );
        }
    }

    public int getRiskLevel() 
    {
        return riskLevel;
    }
}

