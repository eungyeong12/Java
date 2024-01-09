public class Person implements PersonActivity {
    private String name;
    private int reg_id;
    public Person(String nm, int reg_id) {
        this.name = nm;
        this.reg_id = reg_id;
    }
    public String getName() {
        return name;
    }
    public int getRegID() {
        return reg_id;
    }
    @Override
    public void listen() {
        System.out.println("listening ...");
    }
    @Override
    public void talk() {
        System.out.println("talking ...");
    }
    @Override
    public void move() {
        System.out.println("moving ...");
    }
}
