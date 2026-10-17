package security;

import java.io.File;
import java.util.Scanner;

public class SecurityApp {
    
    private File file;
    private String fileName;
    private int riskLevel;

    public SecurityApp(File testFile) 
    {
        file = testFile;
        riskLevel = setRiskLevel(0);
    }

    public void scanFile() 
    {
        Scanner input = new Scanner(this.file);    
        int dotIndex = fileName.lastIndexOf(".");
        

       
    }

    public static String detectFileType()
    {
        File fileTemp = this.file;
        Scanner input = new Scanner(fileTemp); 
        int dotIndex = fileName.lastIndexOf(".");

         if(dotIndex != -1) {
            String fileExtension = fileName.substring(dotIndex + 1);
            System.out.println("File extension: " + fileExtension);

            if ("java".equals(fileExtension)) 
            {
                System.out.println("File type: Java"); // Example risk level for Java files
            }
            else if ("js".equals(fileExtension)) 
            {
                System.out.println("File type: JavaScript"); // Example risk level for JavaScript files
            }
            else if("py".equals(fileExtension)) 
            {
                System.out.println("File type: Python"); // Example risk level for Python files
            }
        }
        else 
        {
            System.out.println("No file extension found.");
        }

        input.close();
        System.out.println("Risk level: " + riskLevel);int dotIndex = fileName.lastIndexOf(".");
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
