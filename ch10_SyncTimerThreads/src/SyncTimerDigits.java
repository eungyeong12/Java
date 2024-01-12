public class SyncTimerDigits extends Thread {
    Object mutex;
    SyncTimerDigits(String name, Object mtx) {
        super(name);
        this.mutex = mtx;
    }

    public void run() {
        int round = 0;
        while(true) {
            synchronized (this.mutex) {
                System.out.println("SyncTimerDigits - round(" + round + ")");
                for(int i=0; i<=20; i++) {
                    System.out.print(i + ",");
                }
                System.out.println();
            }
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                return;
            }
            round++;
        }
    }
}
