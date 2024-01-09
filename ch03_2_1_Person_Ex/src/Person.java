public class Person {
    private String name;
    private int reg_ID;
    static int num_person;
    public Person() {

    }
    public Person(String nm, int reg_ID) {
        this.name = nm;
        this.reg_ID = reg_ID;
        this.num_person += 1;
    }

    public void print_person() {
        System.out.printf("Person(name: %8s, reg_id: %7d, num_person: %2d)\n",
                this.name, this.reg_ID, this.num_person);
    }

    public String getName() {
        return this.name;
    }
}
