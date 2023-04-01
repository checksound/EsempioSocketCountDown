import java.io.*;
import java.net.*;

public class SerialServerCountDown {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8000)) {
            System.out.println("Server avviato, in attesa di connessioni...");
            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    System.out.println("Connessione accettata da " + socket.getInetAddress().getHostAddress());
                    int num = Integer.parseInt(new BufferedReader(new InputStreamReader(socket.getInputStream())).readLine());
                    System.out.println("Numero ricevuto dal client: " + num);
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    for (int i = num; i >= 0; i--) {
                        out.println(i);
                        Thread.sleep(1000);
                    }
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}