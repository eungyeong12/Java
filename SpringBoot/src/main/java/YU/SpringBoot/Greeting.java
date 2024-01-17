package YU.SpringBoot;

public class Greeting {
    private long id = 0;
    private String content = null;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
