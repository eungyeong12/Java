import java.io.IOException;
import java.io.PipedOutputStream;

public class Writer implements Runnable {
    private PipedOutputStream pipedOutputStream;

    public Writer(PipedOutputStream pipedOutputStream) {
        this.pipedOutputStream = pipedOutputStream;
    }

    public void run() {
        try {
            String msg = "Hello, Reader!";
            pipedOutputStream.write(msg.getBytes());
            System.out.println("WriterSent: " + msg);
            pipedOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
