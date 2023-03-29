package es4;

import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer{
    public static void main(String[] args) throws Exception{
        ServerSocket server = new ServerSocket(5353);
        Socket client;
        Thread[] threads = new Thread[5];
        Boolean flag = false;

        while(true){
            client = server.accept();
            while(!flag){
                for(int i = 0; i < threads.length; i++){
                    if(threads[i] == null || !threads[i].isAlive()){
                        threads[i] = new Thread(new ServeOneClient(client));
                        threads[i].start();
                        flag = true;
                        break;
                    }
                }
            }
            flag = false;
        }
    }
}