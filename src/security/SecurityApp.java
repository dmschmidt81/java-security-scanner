package security;

import java.io.File;
import java.util.Scanner;

public class SecurityApp {
    
    
    private int riskLevel;

    public SecurityApp() 
    {
        riskLevel = setRiskLevel(0);
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


    public void scanFile(File fileName) 
    {
        Scanner input = new Scanner(fileName);   
        int dotIndex = fileName.lastIndexOf(".");
        

       
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
