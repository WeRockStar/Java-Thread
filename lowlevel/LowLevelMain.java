package lowlevel;

public class LowLevelMain {

    public static void main(String[] arsg) throws InterruptedException {
        ThreadTask thread = new ThreadTask(4);

        new Thread(thread).start();
        synchronized (thread) {
            thread.wait();
        }
        int[] currentScore = thread.getScores();
        for (int score : currentScore) {
            System.out.println(score + " ");
        }
    }
}
