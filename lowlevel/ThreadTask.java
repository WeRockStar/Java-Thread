package lowlevel;

public class ThreadTask implements Runnable {

    private static int[] scores;
    private int[] source = {1, 2, 3, 4, 5};

    public ThreadTask(int num) {
        if (num > source.length) {
            num = source.length;
            System.out.println("Limiting to " + source.length);
        }
        //define length of array
        scores = new int[num];
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < scores.length; i++) {
                System.out.println(i + 1);
                //sleep 1s
                Thread.sleep(1000);
                scores[i] = source[i];
            }
            synchronized (this) {
                this.notifyAll();
            }
        } catch (Exception e) {

        }
    }

    public synchronized int[] getScores() {
        return scores;
    }
}
