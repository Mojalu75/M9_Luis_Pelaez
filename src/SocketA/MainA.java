package SocketA;

import java.util.Scanner;

public class MainA {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        SocketA A = new SocketA(7777);
        System.out.println("Dime el algoritmo");
        A.enviarMissatge("localhost", A.ex1(sc.nextLine()));
    }
}