package es1;
public class BasicThread implements Runnable{
    private String name = "";
    private SharedObject sharedObject;

    public BasicThread(String name, SharedObject sharedObject) {
        this.name = name;
        this.sharedObject = sharedObject;
    }

    public void run() {
        for(int i = 0; i < 3; i++){
            //System.out.println("Numero di incrementi attuali: " + sharedObject.getNumWrite());
            sharedObject.setNumWrite(sharedObject.getNumWrite()+1);
            sharedObject.setLastWriter(Thread.currentThread().getName());
            System.out.println("Sta eseguendo il thread: " +sharedObject.getLastWriter() + " con valore: " + sharedObject.getNumWrite());
        }
    }
}
