public class TimerRunnableDigits implements Runnable {
    public void run() {
        while(true) {
            for(int n=0; n<20; n++) {
                System.out.print(n + ",");
            }
            System.out.println();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}