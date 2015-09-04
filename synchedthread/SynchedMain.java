package synchedthread;

public class SynchedMain {
public static volatile Boolean shouldStop;
    public static void main(String[] args) {        
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        shouldStop = new Boolean(false);
                        //5 sec
                        final long wait =  System.currentTimeMillis() + 5000;
                        for(;;){
                           synchronized(shouldStop){
                               shouldStop = System.currentTimeMillis() > wait;
                               System.out.println("thread : " + shouldStop);
                           }
                        }
                    }
                }
        ).start();
        
        for(;;){
            if(shouldStop){
                System.exit(0);
            }
        }
    }
}
