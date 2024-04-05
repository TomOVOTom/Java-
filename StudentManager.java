import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
    private List<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(String id) {
        students.removeIf(student -> student.getId().equals(id));
    }

    public void listStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Student Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. List Students");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter gender: ");
                    String gender = scanner.nextLine();
                    manager.addStudent(new Student(id, name, age, gender));
                    break;
                case 2:
                    System.out.print("Enter ID to remove: ");
                    String removeId = scanner.nextLine();
                    manager.removeStudent(removeId);
                    break;
                case 3:
                    manager.listStudents();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, 3, or 4.");
                    break;
            }
        }
    }
}