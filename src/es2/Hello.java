package es2;

public class Hello implements Runnable{

    public void run() {
        while(true){
            System.out.println("Hello");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Termino");
                e.printStackTrace();
                break;
            }
        }
    }    
}
