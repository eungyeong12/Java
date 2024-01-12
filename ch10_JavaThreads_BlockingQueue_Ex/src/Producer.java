import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    private BlockingQueue<String> queue;

    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            for(int i=1; i<=5; i++) {
                String item = "Item " + i;
                queue.put(item);
                System.out.println("Producer produced & sent: " + item);
            }
            queue.put("Bye");
            System.out.printf("Producer sent Bye\n");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
