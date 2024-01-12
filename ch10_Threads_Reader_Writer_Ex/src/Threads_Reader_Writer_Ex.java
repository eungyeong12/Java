import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Threads_Reader_Writer_Ex {
    Threads_Reader_Writer_Ex() throws IOException {
        PipedInputStream pipedInputStream = new PipedInputStream();
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        pipedInputStream.connect(pipedOutputStream);
        Thread writerThread = new Thread(new Writer(pipedOutputStream));
        Thread readerThread = new Thread(new Reader(pipedInputStream));
        writerThread.start();
        readerThread.start();
    }

    public static void main(String[] args) throws IOException {
        new Threads_Reader_Writer_Ex();
    }
}
