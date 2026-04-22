import java.io.*;
import java.util.*;

class Student {
    int id;
    String name;
    int marks;
    Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
    public String toString() {
        return id + "," + name + "," + marks;
    }
}
public class Main {

    static final String FILE = "students.txt";

    public static void addStudent(Student s) throws IOException {
        FileWriter fw = new FileWriter(FILE, true);
        fw.write(s + "\n");
        fw.close();
    }
    public static void viewStudents() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(FILE));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }
    public static void updateStudent(int id, String newName, int newMarks) throws IOException {
        File file = new File(FILE);
        File temp = new File("temp.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));
        FileWriter fw = new FileWriter(temp);

        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            if (Integer.parseInt(data[0]) == id) {
                fw.write(id + "," + newName + "," + newMarks + "\n");
            } else {
                fw.write(line + "\n");
            }
        }
        br.close();
        fw.close();

        file.delete();
        temp.renameTo(file);
    }
    public static void deleteStudent(int id) throws IOException {
        File file = new File(FILE);
        File temp = new File("temp.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));
        FileWriter fw = new FileWriter(temp);

        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            if (Integer.parseInt(data[0]) != id) {
                fw.write(line + "\n");
            }
        }
        br.close();
        fw.close();

        file.delete();
        temp.renameTo(file);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("\n1.Add 2.View 3.Update 4.Delete 5.Exit");
                int ch = sc.nextInt();

                if (ch == 1) {
                    System.out.print("ID Name Marks: ");
                    addStudent(new Student(sc.nextInt(), sc.next(), sc.nextInt()));
                }
                else if (ch == 2) {
                    viewStudents();
                }
                else if (ch == 3) {
                    System.out.print("Enter ID to update: ");
                    int id = sc.nextInt();
                    System.out.print("New Name Marks: ");
                    updateStudent(id, sc.next(), sc.nextInt());
                }
                else if (ch == 4) {
                    System.out.print("Enter ID to delete: ");
                    deleteStudent(sc.nextInt());
                }
                else break;
            }
        } 
        catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
       sc.close();
    }
}
