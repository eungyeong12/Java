import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class StudentArray extends Student {
    private Student[] students;
    private int num_students;

    public StudentArray() {

    }
    public void fget_students(Scanner fin) {
        int count = 0;
        while(fin.hasNext()) {
            num_students = fin.nextInt();
            students = new Student[num_students];
            for(int i=0; i<num_students; i++) {
                String nm = fin.next();
                int reg_id = fin.nextInt();
                int st_id = fin.nextInt();
                String dept = fin.next();
                String school = fin.next();
                double gpa = fin.nextDouble();
                Student student = new Student(nm, reg_id, st_id, dept, school, gpa);
                students[count++] = student;
            }
        }
    }

    public void print_students() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void fprint_students(FileWriter fout) throws IOException {
        if(students != null) {
            for (Student student : students) {
                fout.write(student.toString()+"\n");
            }
        }
    }

    public void sort(String key_attr, String sorting_order) {
        Student temp;
        int i, j;

        switch (key_attr) {
            case "name":
                for(i=1; i<students.length; ++i) {
                    char key = students[i].getName().charAt(0);
                    temp = students[i];
                    j = i-1;
                    if(sorting_order.equals("increasing")) {
                        while(j>=0 && compareStudent("name", students[j], key) > 0) {
                            students[j+1] = students[j];
                            j--;
                        }
                    } else if(sorting_order.equals("decreasing")) {
                        while(j>=0 && compareStudent("name", students[j], key) <= 0) {
                            students[j+1] = students[j];
                            j--;
                        }
                    }
                    students[j+1] = temp;
                }
                break;
            case "st_id":
                for(i=1; i<students.length; i++) {
                    int key = students[i].getSt_id();
                    temp = students[i];
                    j = i;
                    if(sorting_order.equals("increasing")) {
                        for(;j>0 && compareStudent("st_id", students[j-1], key) > 0; --j) {
                            students[j] = students[j-1];
                        }
                    } else if(sorting_order.equals("decreasing")) {
                        for(;j>0 && compareStudent("st_id", students[j], key) <= 0; --j) {
                            students[j] = students[j-1];
                        }
                    }
                    students[j] = temp;
                }
                break;
            case "GPA":
                for(i=1; i<students.length; i++) {
                    double key = students[i].getGPA();
                    temp = students[i];
                    j = i;
                    if(sorting_order.equals("increasing")) {
                        for(;j>0 && compareStudent("GPA", students[j-1], key) > 0; --j) {
                            students[j] = students[j-1];
                        }
                    } else if(sorting_order.equals("decreasing")) {
                        for(;j>0 && compareStudent("GPA", students[j-1], key) <= 0; --j) {
                            students[j] = students[j-1];
                        }
                    }
                    students[j] = temp;
                }
                break;
        }

    }
}