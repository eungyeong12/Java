public class Teacher extends Person implements TeacherActivity {
    String school;
    String major;
    String lecture;

    public Teacher(String nm, int reg_id, String school, String major, String lecture) {
        super(nm, reg_id);
        this.school = school;
        this.major = major;
        this.lecture = lecture;
    }

    public String toString() {
        return "Teacher(" + getName() + ", " + getRegID() + ", " + school + ", " + major + ")";
    }
    public String getMajor() {
        return major;
    }
    @Override
    public void listen() {
        System.out.println("teacher(" + getName() + ", " + major + ") :: listening ...");
    }
    @Override
    public void talk() {
        System.out.println("teacher(" + getName() + ", " + major + ") :: talking ...");
    }
    @Override
    public void move() {
        System.out.println("teacher(" + getName() + ", " + major + ") :: moving ...");
    }
    @Override
    public void teach() {
        System.out.println("teacher(" + getName() + ", " + major + ") :: teaching ...");
    }
}
