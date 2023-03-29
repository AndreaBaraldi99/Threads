package es4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServeOneClient implements Runnable {
    Socket client;
    BufferedReader in;
    PrintWriter out;
    String response;

    public ServeOneClient(Socket client) throws IOException{
        this.client = client;
        this.in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        this.out = new PrintWriter(client.getOutputStream());
    }

    public void run(){
        try {
            System.out.println("Avviato il thread " + Thread.currentThread().getName());
            response = in.readLine();
            System.out.println("Letta la stringa " + response);
            out.println(response);
            out.flush();
            System.out.println("Reinviata la stringa");
            Thread.sleep(200);
            in.close();
            out.close();
            client.close();
            System.out.println("Connection closed");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }        
    }   
}
