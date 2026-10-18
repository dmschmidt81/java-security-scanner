package security;

import java.io.File;


public class SecurityAppRunner {
    public static void main(String[] args) {

        File testFile = new File("examples/Testfile.java");
        SecurityApp app = new SecurityApp();
        String fileType = app.detectFileType(testFile.getName());
        if (!fileType.equals("Unknown")) {
            app.scanFile(testFile);
        } else {
            System.out.println("Cannot scan file: Unknown type");
        }
        System.out.println("Final risk level: " + app.getRiskLevel());
    }
}
