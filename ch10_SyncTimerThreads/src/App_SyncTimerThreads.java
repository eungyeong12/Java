public class App_SyncTimerThreads {
    public static void main(String[] args) {
        System.out.println("SyncTimerThreadsEx .....");
        Object mutex = new Object();
        Thread th_digits = new SyncTimerDigits("SyncTimerDigits", mutex);
        Thread th_abc = new SyncTimerABC("SyncTimerABC", mutex);
        Thread th_korean = new SyncTimerKorean("SyncTimerKorean", mutex);
        th_digits.start();
        th_abc.start();
        th_korean.start();
    }
}
