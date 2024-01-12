import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            String item;
            while(true) {
                item = queue.take();
                if(item.equals("Bye")) {
                    System.out.printf("Consumer received Bye. So exits !!!\n");
                    break;
                }
                System.out.println("Comsumer received & consumed: " + item);
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
