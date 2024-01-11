public class Person {
    private String name;
    private int reg_id;

    public Person() {

    }

    public Person(String nm, int reg_id) {
        this.name = nm;
        this.reg_id = reg_id;
    }

    public String getName() {
        return name;
    }

    public int getReg_id() {
        return reg_id;
    }
}
