package es2;

import java.util.Scanner;

public class App {
    
    public static void main(String[] args){
        try {
            Thread t1 = new Thread(new Hello());
            Scanner scanner = new Scanner(System.in);

            t1.start();
            String input = scanner.nextLine();
            if(input.equals("fine"))
                t1.interrupt();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
