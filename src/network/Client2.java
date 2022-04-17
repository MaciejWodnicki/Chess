package network;

import gui.MyFrame;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import static gui.MyPanel.gameBoard;

public class Client2 {
    public static void main(String[] args) throws Exception{
        new Client2();

    }

    public Client2() throws Exception
    {
        MyFrame myFrame = new MyFrame();
        Socket socket = new Socket("127.0.0.2",Server.PORT);

        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

        Packet packet = new Packet("message form client 2");

        outputStream.writeObject(packet);


        socket.close();

    }
}
