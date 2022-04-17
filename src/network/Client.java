package network;

import gui.MyFrame;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import static gui.MyPanel.gameBoard;

public class Client {
    public static void main(String[] args) throws Exception{
        new Client();

    }

    public Client() throws Exception
    {
        MyFrame myFrame = new MyFrame();
        Socket socket = new Socket("127.0.0.1",Server.PORT);

        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

        Packet newPacket= null;
        Packet oldPacket = null;

        Packet packet = new Packet("message form client 1");

        outputStream.writeObject(packet);


        socket.close();
        //while(true)
        {
/*
            oldPacket = newPacket;
            newPacket = (Packet) inputStream.readObject();
            if(oldPacket!=newPacket)
            {
                System.out.println("p1 moved");
                outputStream.writeObject(newPacket);
                newPacket = (Packet) inputStream.readObject();

                gameBoard = newPacket.board;
            }




            if(myFrame!=null)
                break;
*/

        }

        //socket.close();

    }
}
