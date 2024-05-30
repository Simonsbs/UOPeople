import java.io.*;
import java.net.*;

/**
 * The ChatClient class implements a client for an online chat application.
 * It connects to a central chat server, allows the user to send and receive
 * messages.
 */
public class ChatClient {
    private static final String HOST = "localhost";
    private static final int PORT = 1223;

    /**
     * The main method connects to the chat server, sends the username to the
     * server, and starts a thread to handle incoming messages from the server.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        try (Socket socket = new Socket(HOST, PORT);
                BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter toServer = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("**********************************************");
            System.out.println("**    Connected to the chat party server    **");
            System.out.println("**********************************************");
            System.out.print("Enter your name: ");
            String username = userInput.readLine();
            toServer.println(username);

            System.out.println("Logging in to the chat server as: " + username);

            new Thread(new ServerMessageHandler(fromServer)).start();

            displayHelp();

            String message;
            while (true) {
                message = userInput.readLine();
                if (message == null || message.toLowerCase().equals("/exit")) {
                    break;
                } else if (message.toLowerCase().equals("/help")) {
                    displayHelp();
                } else {
                    toServer.println(message);
                }
            }
        } catch (IOException e) {
            System.err.println("Connection error: " + e.getMessage());
        }
    }

    /**
     * Displays the help screen with available commands.
     */
    private static void displayHelp() {
        System.out.println("Available commands:");
        System.out.println("\t/help - Show this help message");
        System.out.println("\t/pm <username> <message> - Send a private message to a user");
        System.out.println("\t/ul - List all connected users");
        System.out.println("\t/exit - Exit the chat");
    }

    /**
     * The ServerMessageHandler class handles incoming messages from the server.
     */
    private static class ServerMessageHandler implements Runnable {
        private BufferedReader in;

        /**
         * Constructs a ServerMessageHandler with the given BufferedReader.
         *
         * @param in The BufferedReader to read messages from the server.
         */
        public ServerMessageHandler(BufferedReader in) {
            this.in = in;
        }

        /**
         * The run method reads messages from the server and prints them to the console.
         */
        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println(message);
                }
            } catch (IOException e) {
                System.err.println("Error getting messages: " + e.getMessage());
            }
        }
    }
}
