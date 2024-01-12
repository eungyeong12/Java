public class SyncTimerKorean extends Thread {
    Object mutex;
    SyncTimerKorean(String name, Object mtx) {
        super(name);
        this.mutex = mtx;
    }
    public void run() {
        String s = "가나다라마바사아자차카타파하";
        char[] c = s.toCharArray();
        while(true) {
            synchronized (this.mutex) {
                for(int n=0; n<14; n++) {
                    System.out.print(c[n] + ",");
                }
                System.out.println();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

}
