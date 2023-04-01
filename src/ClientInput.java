import java.io.*;
import java.net.*;

public class ClientInput {
	    public static void main(String[] args) {
	        try (Socket socket = new Socket("localhost", 8000)) {
	            System.out.println("Connected client socket: " + socket);
	            BufferedReader consoleIn = new BufferedReader(new InputStreamReader(System.in));
	            System.out.print("Inserisci un numero da 1 a 1000: ");
	            int num = Integer.parseInt(consoleIn.readLine());
	            System.out.println("Numero inserito dal client: " + num);
	            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
	            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	            out.println(num);
	            String line;
	            while ((line = in.readLine()) != null) {
	                System.out.println(line);
	            }
	        } catch (Exception e) {
	            System.err.println("Errore durante la comunicazione con il server: " + e.getMessage());
	        }
	    }
	}

