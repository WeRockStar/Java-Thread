package threadsimple;

public class AnotherThread implements Runnable{

    @Override
    public void run() {
        while(true){
            System.out.println("Another Thread...");
        }
    }    
}
