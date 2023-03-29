package es4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread implements Runnable{
    
    
    public static void main(String[] args){
        try {
            Thread[] threads = new Thread[3];
            for(int i = 0; i < threads.length; i++){
                String name = "t" + i;
                threads[i] = new Thread(new ClientThread(), name);
                threads[i].start();
            }
            for(int i = 0; i < threads.length; i++){
                threads[i].join();
            }
            System.out.println("Thread main terminato");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run(){
        try {
            Socket client = new Socket("localhost", 5353);
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream());
            String response = "Stringa di test";
            System.out.println("Collegato all'host " + client.getInetAddress());
            out.println(response);
            out.flush();
            System.out.println("E' stata mandata la stringa");
            Thread.sleep(100);
            response = in.readLine();
            System.out.println("E' stata ricevuta la seguente stringa: " + response);
            Thread.sleep(100);
            out.close();
            in.close();
            client.close();
            System.out.println("Connessione chiusa");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
