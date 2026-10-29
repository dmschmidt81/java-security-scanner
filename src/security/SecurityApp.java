package security;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class SecurityApp {
    
    
    private int riskLevel;
    private ArrayList<SecurityRule> securityRules;


    public SecurityApp(ArrayList<SecurityRule> securityRules) 
    {
        riskLevel = 0;
        this.securityRules = securityRules;
    }

    

    public static String detectFileType(String fileName, File file)
    {
        
        int dotIndex = fileName.lastIndexOf(".");

         if(dotIndex != -1) {
            String fileExtension = fileName.substring(dotIndex + 1);
            System.out.println("File extension: " + fileExtension);

            if ("java".equals(fileExtension)) 
            {
                return "File type: Java"; // Example risk level for Java files
            }
            else if ("js".equals(fileExtension)) 
            {
                return "File type: JavaScript"; // Example risk level for JavaScript files
            }
            else if("py".equals(fileExtension)) 
            {
                return "File type: Python"; // Example risk level for Python files
            }
            else if("txt".equals(fileExtension)) 
            {
                return "File type: Text"; // Example risk level for Text files
            }
            else 
            {
                return "Unknown";
            }
        }

        input.close();
        System.out.println("Risk level: " + riskLevel);

    }


    public void scanFile(File file) 
    {
        riskLevel = 0; // Reset risk level before scanning
        try( Scanner input = new Scanner(file))
        {
            while (input.hasNextLine()) 
            {

                String line = input.nextLine();


                // Check each line against every security rule
                for (SecurityRule rule : securityRules) 
                {

                    String pattern = rule.getPattern();
                    
                    if (line.matches(pattern)) 
                    {
                        System.out.println("Potential match: " + rule.getRuleName());
                        riskLevel += rule.getRiskWeight();
                    }
                }
            }
        }
        catch (FileNotFoundException e)
        {
            System.err.println("File not found: " + e.getMessage());
        }
    }

    private int setRiskLevel(int Level) 
    {
        this.riskLevel = Level;
        return riskLevel;
    }
    

    public int getRiskLevel() 
    {
        return riskLevel;
    }

}
