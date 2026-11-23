package SocketA;

import java.io.IOException;
import java.net.*;
import java.security.MessageDigest;
import java.util.HexFormat;
import java.util.Scanner;

public class SocketA {
    private int portEnviar;

    public SocketA(int portEnviar) {
        this.portEnviar = portEnviar;

    }
    public String ex1(String algoritme) throws Exception{
        String txt = "Luis Pelaez Martos - 23/11/2026";
        byte[] data = txt.getBytes();
        MessageDigest md = MessageDigest.getInstance(algoritme);
        byte[] hash = md.digest(data);

        String hex = HexFormat.of().formatHex(hash);
        System.out.println("El hash de el nom " + txt + "  és : " + hex);
        return hex;
    }
    public void enviarMissatge(String ipDesti, String missatge) throws IOException {
        byte[] bitesMissatge = missatge.getBytes();
        InetAddress desti = InetAddress.getByName(ipDesti);
        DatagramPacket packet = new DatagramPacket(bitesMissatge, bitesMissatge.length, desti, portEnviar);
        DatagramSocket socket = new DatagramSocket();
        socket.send(packet);
        socket.close();
        System.out.println("Paquet amb contingut " + missatge + " enviat al socol amb  " + desti);
    }
}
