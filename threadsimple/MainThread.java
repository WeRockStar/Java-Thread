package threadsimple;
public class MainThread {
    public static void main(String[] args) {
        (new Thread(new AnotherThread())).start();
        while (true) {            
            System.out.println("main thread");
        }
    }   
}
