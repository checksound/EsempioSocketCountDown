import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MultithreadingServerCountDown {

    public static class Handler extends Thread {

        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                System.out.println("Connessione accettata: " + socket);
                int num = Integer.parseInt(new BufferedReader(new InputStreamReader(socket.getInputStream())).readLine());
                System.out.println("Numero ricevuto dal client: " + num);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                for (int i = num; i >= 0; i--) {
                    out.println(i);
                    Thread.sleep(200);
                }
                out.close();
                socket.close();
            } catch (IOException | InterruptedException e) {
                System.out.println("Exception: " + e);
            }

        }

    }
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8000)) {
            System.out.println("Server avviato, in attesa di connessioni...");
            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    Thread worker = new Handler(socket);
                    worker.start();
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}