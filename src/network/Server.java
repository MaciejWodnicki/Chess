package network;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int PORT = 3191;

    public static void main(String[] args) throws Exception {
        new Server();
    }

    public Server() throws Exception
    {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is up and running on port: "+PORT+"!");
        Socket socket = serverSocket.accept();

        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

        Packet recvPacket1 = (Packet) inputStream.readObject();
        Packet recvPacket2 = (Packet) inputStream.readObject();

        System.out.println(recvPacket1.message);
        System.out.println(recvPacket2.message);




       // serverSocket.close();
    }
}
