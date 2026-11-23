package SocketB;

import org.apache.commons.net.ftp.FTPClient;

import java.io.IOException;

public class MainB {
    public static void main(String[] args) throws IOException {
        SocketB B = new SocketB(7777, 7777);
        B.ex1();
    }
}