package SocketB;

import org.apache.commons.net.ftp.FTPClient;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class MainB {
    public static void main(String[] args) throws IOException {
        SocketB B = new SocketB(7777, 7777);
        B.ex1();
        ServerSocket serverSocket = new ServerSocket(6666);
        Socket socket = serverSocket.accept();
        InetAddress desti = InetAddress.getByName("localhost");
        OutputStream os = socket.getOutputStream();
        PrintWriter enviador = new PrintWriter(os, true);
        enviador.println("Misatge Encripta Luis Pelaez Martos enviat al socol amb ip " + desti);
        enviador.close();
    }
}