public class Student extends Person implements StudentActivity {
    private int st_id;
    private double gpa;
    private String school;
    private String major;

    public Student(String nm, int reg_id, String school, String major, int st_id, double st_gpa) {
        super(nm, reg_id);
        this.school = school;
        this.major = major;
        this.st_id = st_id;
        this.gpa = st_gpa;
    }
    public int getStID() {
        return st_id;
    }
    public double getGPA() {
        return gpa;
    }
    public String toString() {
        return "Student(" + getName() + ", " + getRegID() + ", " + school + ", " + major + ", " + st_id + ")";
    }
    @Override
    public void listen() {
        System.out.println("student(" + getName() + ", " + st_id + ") :: listening ...");
    }
    @Override
    public void talk() {
        System.out.println("student(" + getName() + ", " + st_id + ") :: talking ...");
    }
    @Override
    public void study() {
        System.out.println("student(" + getName() + ", " + st_id + ") :: studying ...");
    }
}
