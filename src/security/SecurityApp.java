package security;

import java.io.File;

public class SecurityApp {
    

    public SecurityApp() {

        System.out.println("SecurityApp initialized.");
    }

    public void scanFile(File testFile) {
        String fileName = testFile.getName();
        int dotIndex = fileName.lastIndexOf(".");
        int riskLevel = 0;
       

        if(dotIndex != -1) {
             String fileExtension = fileName.substring(dotIndex + 1);
            System.out.println("File extension: " + fileExtension);

            if ("java".equals(fileExtension)) {
            riskLevel++; // Example risk level for Java files
            }
            else if ("js".equals(fileExtension)) {
            riskLevel++; // Example risk level for JavaScript files
            }
            else if("py".equals(fileExtension)) {
            riskLevel++; // Example risk level for Python files
            }

        }
        else {
            System.out.println("No file extension found.");
        }
        System.out.println("Risk level: " + riskLevel);
    }
}
