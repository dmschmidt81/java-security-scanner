package security;

import java.io.File;


public class SecurityAppRunner {
    public static void main(String[] args) {

        File testFile = new File("examples/Testfile.java");
        SecurityApp app = new SecurityApp(testFile);
        app.detectFileType(testFile.getName());
        System.out.println("Final risk level: " + app.getRiskLevel());
    }
}
