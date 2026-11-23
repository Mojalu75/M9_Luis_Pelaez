package SocketC;

import org.apache.commons.net.ftp.FTPClient;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;

public class SocketC {
    public void ex3() throws IOException {
        Socket client = new Socket("localhost", 6666);

        BufferedReader entrada = new BufferedReader(new InputStreamReader(client.getInputStream(), StandardCharsets.UTF_8));

        String missatge;

        while ((missatge = entrada.readLine()) != null) {
            System.out.println("Socket TCP - Missatge rebut: " + missatge);

        }

        System.out.println("Conexio Tancada");
        FTPClient ftpClient = new FTPClient();
        ftpClient.connect("ftpupload.net", 21);
        ftpClient.login("if0_43334517", "ijX7SxyUtuAYX");
        System.out.println("Conexio FTP establerta  correctament");

        String rutaRemota = "/htdocs/examen/hashLuisPelaez.txt";
        try (InputStream inputStream = ftpClient.retrieveFileStream(rutaRemota)) {

            if (inputStream == null) {
                throw new FileNotFoundException("El fitxer '"  + "' no existeix.");
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String linia;
            System.out.println("Contingut :");
            while ((linia = reader.readLine()) != null) {
                System.out.println(linia);
            }

            ftpClient.completePendingCommand();

        } catch (Exception e) {
            System.out.println("S'ha produït un error en llegir." + e.getMessage());
        }
    }
}
