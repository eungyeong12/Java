public class Student extends Person {
    private int st_id;
    private String dept;
    private String school;
    private double GPA;

    public Student() {

    }

    public Student(String nm, int reg_ID, int st_id, String dept, String school, double gpa) {
        super(nm, reg_ID);
        this.st_id = st_id;
        this.dept = dept;
        this.school = school;
        this.GPA = gpa;
    }

    public void setSt_id(int st_id) {
        this.st_id = st_id;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public int getSt_id() {
        return st_id;
    }

    public String getDept() {
        return dept;
    }

    public String getSchool() {
        return school;
    }

    public double getGPA() {
        return GPA;
    }

    public String toString() {
        String str = String.format("Student(name: %5s, reg_id: %8d, school: %5s, dept: %5s, st_id: %6d, GPA: %.2f)", getName(), getReg_id(), school, dept, st_id, GPA);
        return str;
    }

    public int compareStudent(String key_attr, Student other, Object key) {
        switch (key_attr) {
            case "name":
                if(key instanceof Character) {
                    char c = (char)key;
                    if(other.getName().charAt(0) > c)
                        return 1;
                }
                break;
            case "st_id":
                if(key instanceof Integer) {
                    int i = (int)key;
                    if(other.getSt_id() >= i)
                        return 1;
                }
                break;
            case "GPA":
                if(key instanceof Double) {
                    double d = (double)key;
                    if(other.getGPA() >= d)
                        return 1;
                }
                break;
        }
        return 0;
    }


}
