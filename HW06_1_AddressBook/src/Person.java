public class Person {
    String name;
    TelNum telNo;
    public Person(String nm, TelNum telNo) {
        this.name = nm;
        this.telNo = telNo;
    }
    public String toString() {
        String str = String.format("Person(Name=%8s, telNo=%20s)", this.name, this.telNo);
        return str;
    }

    public String getName() {
        return name;
    }
}
