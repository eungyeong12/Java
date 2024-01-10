import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App_Students_FileIO {
    public static void main(String[] args) throws IOException {
        final String fin_name = "students.txt";
        final String fout_name = "processed_students.txt";
        StudentArray students = new StudentArray();
        Scanner fin = new Scanner(new File(fin_name));
        FileWriter fout = new FileWriter(fout_name);
        students.fget_students(fin);

        System.out.println("Before sorting: ");
        students.print_students();
        fout.write("Initial state of students: \n");
        students.fprint_students(fout);
        students.sort("name", "increasing");
        System.out.print("\nAfter sorting by name: \n");
        students.print_students();
        fout.write("\nAfter sorting by name: \n");
        students.fprint_students(fout);

        students.sort("st_id", "increasing");
        System.out.print("\nAfter sorting by reg_id: \n");
        students.print_students();
        fout.write("\nAfter sorting by reg_id: \n");
        students.fprint_students(fout);

        students.sort("GPA", "decreasing");
        System.out.print("\nAfter sorting by GPA: \n");
        students.print_students();
        fout.write("\nAfter sorting by GPA: \n");
        students.fprint_students(fout);
        fout.close();
    }
}
