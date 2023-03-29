package es1;
public class SharedObject {
    private int numWrite = 0;
    private String lastWriter = "";

    public synchronized int getNumWrite() {
        return numWrite;
    }

    public synchronized String getLastWriter() {
        return lastWriter;
    }

    public synchronized void setLastWriter(String lastWriter) {
        this.lastWriter = lastWriter;
    }

    public synchronized void setNumWrite(int numWrite) {
        this.numWrite = numWrite;
    }
}
