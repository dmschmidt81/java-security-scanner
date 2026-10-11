package security;

import java.io.File;


public class SecurityAppRunner {
    public static void main(String[] args) {

        File testFile = new File("examples/Testfile.java");
        SecurityApp app = new SecurityApp();
        app.scanFile(testFile);
    }
}
