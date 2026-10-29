package examples;

import java.io.File;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;

public class Testfile {
    public static void main(String[] args) throws Exception {
        String data = Files.readString(Path.of("settings.txt"));
        Socket socket = new Socket("example.com", 443);
        File output = new File("results.txt");
        String query = "SELECT * FROM students";

        System.out.println(data);
        System.out.println("Connected to: " + socket.getInetAddress());
        System.out.println("Output file: " + output.getName());

        socket.close();
    }
}
