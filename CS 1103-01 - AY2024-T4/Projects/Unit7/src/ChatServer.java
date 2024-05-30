import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * The ChatServer class implements a server for an online chat application.
 * It manages connections from multiple clients, broadcasts messages to all
 * connected clients, and supports private messaging and listing of connected
 * users.
 */
public class ChatServer {
    private static final int PORT = 1223;
    private static Set<ClientHandler> clients = new HashSet<>();
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private static int clientIdCounter = 1;

    /**
     * The main method starts the chat server, listening for client connections
     * on a specified port.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        System.out.println("*************************************");
        System.out.println("**    Chat party server running    **");
        System.out.println("*************************************");
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                new ClientHandler(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            log("Error starting server: " + e.getMessage());
        }
    }

    /**
     * Logs server messages with a timestamp.
     *
     * @param message The message to log.
     */
    private static void log(String message) {
        System.out.println(dateFormat.format(new Date()) + " - " + message);
    }

    /**
     * The ClientHandler class handles communication with a single client.
     */
    private static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;
        private String username;
        private int clientId;

        /**
         * Constructs a ClientHandler with the given socket.
         *
         * @param socket The socket connected to the client.
         */
        public ClientHandler(Socket socket) {
            this.socket = socket;
            this.clientId = clientIdCounter++;
        }

        /**
         * The run method processes client messages and handles user commands. It runs
         * in a separate thread.
         */
        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                synchronized (clients) {
                    clients.add(this);
                }

                username = in.readLine();

                log("User " + username + " (ID: " + clientId + ") has joined the chat.");
                sendMessageToAllClients("Server: " + username + " (ID: " + clientId + ") has joined the chat!");

                String message;
                while ((message = in.readLine()) != null) {
                    if (message.startsWith("/pm ")) {
                        sendPrivateMessage(message);
                    } else if (message.equals("/ul")) {
                        listUsers();
                    } else {
                        sendMessageToAllClients(username + ": " + message);
                    }
                }
            } catch (IOException e) {
                log("Client connection error: " + e.getMessage());
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    log("Error closing socket: " + e.getMessage());
                }
                synchronized (clients) {
                    clients.remove(this);
                }
                log("User " + username + " (ID: " + clientId + ") has left the chat.");
                sendMessageToAllClients("Server: " + username + " (ID: " + clientId + ") has left the chat.");
            }
        }

        /**
         * Sends a message to all connected clients.
         *
         * @param message The message to send.
         */
        private void sendMessageToAllClients(String message) {
            synchronized (clients) {
                for (ClientHandler client : clients) {
                    client.out.println(dateFormat.format(new Date()) + " - " + message);
                }
            }
        }

        /**
         * Sends a private message to a specific user.
         * If the target user is not found, a message is sent to the sender.
         *
         * @param message The private message in the format "/pm <username> <message>".
         */
        private void sendPrivateMessage(String message) {
            int firstSpace = message.indexOf(" ");
            int secondSpace = message.indexOf(" ", firstSpace + 1);
            if (secondSpace == -1) {
                out.println("Server: Invalid private message format. Use /pm <username> <message>");
                return;
            }
            String targetUsername = message.substring(firstSpace + 1, secondSpace).toLowerCase();
            String privateMessage = message.substring(secondSpace + 1);

            synchronized (clients) {
                for (ClientHandler client : clients) {
                    if (client.username.toLowerCase().equals(targetUsername)) {
                        client.out.println(
                                dateFormat.format(new Date()) + " - (Private) " + username + ": " + privateMessage);
                        out.println(dateFormat.format(new Date()) + " - (Private to " + targetUsername + ") " + username
                                + ": "
                                + privateMessage);
                        return;
                    }
                }
            }
            out.println("Server: User " + targetUsername + " not found.");
        }

        /**
         * Lists all connected users.
         */
        private void listUsers() {
            StringBuilder userList = new StringBuilder("Server: Connected users: ");
            synchronized (clients) {
                for (ClientHandler client : clients) {
                    userList.append(client.username).append(" (ID: ").append(client.clientId).append("), ");
                }
            }
            out.println(userList.substring(0, userList.length() - 2));
        }
    }
}
