public class SyncTimerABC extends Thread {
    Object mutex;
    SyncTimerABC(String name, Object mtx) {
        super(name);
        this.mutex = mtx;
    }

    public void run() {
        int round = 0;
        while(true) {
            synchronized (this.mutex) {
                System.out.println("SyncTimerABC - round(" + round + ")");
                for(char c ='A'; c<='Z'; c++) {
                    System.out.print(c + ",");
                }
                System.out.println();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
            round++;
        }
    }
}
