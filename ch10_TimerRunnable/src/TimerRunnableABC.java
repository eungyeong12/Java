public class TimerRunnableABC implements Runnable {
    public void run() {
        while(true) {
            for(char c='A'; c<='Z'; c++) {
                System.out.print(c + ",");
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