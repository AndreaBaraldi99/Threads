package es3;

import java.util.Scanner;

public class App {
    
    public static void main(String[] args){
        System.out.println("Inserisci un numero compreso tra 1 e 5");
        Scanner scanner = new Scanner(System.in);
        int threadNumber = scanner.nextInt();
        Thread[] threads = new Thread[threadNumber];
        for(int i = 0; i < threadNumber; i++){
            threads[i] = new Thread(new Number(23), "t" + i);
            threads[i].start();
        }
        for(Thread thread : threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}
