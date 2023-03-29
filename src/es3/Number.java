package es3;

public class Number implements Runnable{

    public int number;

    public Number(int number){
        this.number = number;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            System.out.println("Sono il thread " + Thread.currentThread().getName() + " e stampo il numero " + number + " per la " + (i+1) + " volta");
        }
    }
    
}