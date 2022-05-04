import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        int port = 80;
        try (ServerSocket socket = new ServerSocket(port);
             Socket client = socket.accept();
             PrintWriter out = new PrintWriter(client.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()))) {
            System.out.println("New connection accepted");
            final String name = in.readLine();
            out.println(String.format("Hi %s, your port is %d", name, client.getPort()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
