package SocketB;

import org.apache.commons.net.ftp.FTPClient;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;

public class SocketB {
    private int portEnviar;
    private int portEscoltar;

    public SocketB(int portEnviar, int portEscoltar) {
        this.portEnviar = portEnviar;
        this.portEscoltar = portEscoltar;
    }

    public void ex1() throws IOException {
        byte[] missatge = new byte[1024];
        DatagramSocket socket = null;
        socket = new DatagramSocket(portEscoltar);
        socket.setSoTimeout(10000);

        DatagramPacket packet = new DatagramPacket(missatge, missatge.length);
        socket.receive(packet);
        System.out.println("El Misatge del paquet es " + new String(packet.getData(), 0, packet.getLength()));
        System.out.println("S'ha rebut un paquet provinent de " + packet.getSocketAddress().toString());

        FTPClient ftpClient = new FTPClient();
        ftpClient.connect("ftpupload.net", 21);
        ftpClient.login("if0_43334517", "ijX7SxyUtuAYX");
        System.out.println("Conexio FTP establerta  correctament");
        String nombreRemoto = "hashLuisPelaez.txt";
        File file = new File(nombreRemoto);
        FileWriter writer = new FileWriter("hashLuisPelaez.txt");
        writer.write(packet.toString());

        String rutaRemota = "/htdocs/" + nombreRemoto;

        try (InputStream inputStream = new FileInputStream(nombreRemoto)) {

            boolean pujat = ftpClient.storeFile(rutaRemota, inputStream);

            if (pujat) {
                System.out.println("El fitxer " + nombreRemoto + " s'ha pujat correctament ");
            } else {
                throw new IOException("El servidor ha rebutjat el fitxer.");
            }

        } catch (Exception e) {
            System.out.println("S'ha produit un error al pujar.");
        }
    }
}
