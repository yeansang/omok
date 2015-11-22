package chat;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
 
public class Sender extends Thread {
    String name;
    Socket socket;
    DataOutputStream out;
 
    Sender(Socket socket) {
        this.socket = socket;
        try {
            out = new DataOutputStream(socket.getOutputStream());
            name = "[" + socket.getInetAddress() + ":" + socket.getPort()
                    + "] ";
        } catch (Exception e) {
        }
    }
 
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (out != null) {
            try {
                out.writeUTF(name + scanner.nextLine());
            } catch (IOException e) {
            }
        }
    }
}