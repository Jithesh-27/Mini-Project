package mini.project;

import java.util.ArrayList;
import java.util.Scanner;

class Student {

    int id;
    String name;
    int age;
    String course;

    Student(int id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    void displayStudent() {
        System.out.println("ID     : " + id);
        System.out.println("Name   : " + name);
        System.out.println("Age    : " + age);
        System.out.println("Course : " + course);
        System.out.println("----------------------");
    }
}

public class StudentManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();

        while (true) {

            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

            case 1:
                System.out.print("Enter Student ID: ");
                int id = sc.nextInt();

                sc.nextLine();

                System.out.print("Enter Student Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Age: ");
                int age = sc.nextInt();

                sc.nextLine();

                System.out.print("Enter Course: ");
                String course = sc.nextLine();

                Student student = new Student(id, name, age, course);

                students.add(student);

                System.out.println("Student added successfully!");
                break;

            case 2:

                if (students.isEmpty()) {
                    System.out.println("No students available.");
                } else {

                    for (Student s : students) {
                        s.displayStudent();
                    }
                }

                break;

            case 3:

                System.out.print("Enter Student ID to search: ");
                int searchId = sc.nextInt();

                boolean found = false;

                for (Student s : students) {

                    if (s.id == searchId) {
                        s.displayStudent();
                        found = true;
                    }
                }

                if (!found) {
                    System.out.println("Student not found.");
                }

                break;

            case 4:

                System.out.print("Enter Student ID to update: ");
                int updateId = sc.nextInt();

                sc.nextLine();

                boolean updated = false;

                for (Student s : students) {

                    if (s.id == updateId) {

                        System.out.print("Enter New Name: ");
                        s.name = sc.nextLine();

                        System.out.print("Enter New Age: ");
                        s.age = sc.nextInt();

                        sc.nextLine();

                        System.out.print("Enter New Course: ");
                        s.course = sc.nextLine();

                        System.out.println("Student updated successfully!");

                        updated = true;
                    }
                }

                if (!updated) {
                    System.out.println("Student not found.");
                }

                break;

            case 5:

                System.out.print("Enter Student ID to delete: ");
                int deleteId = sc.nextInt();

                boolean deleted = false;

                for (int i = 0; i < students.size(); i++) {

                    if (students.get(i).id == deleteId) {

                        students.remove(i);

                        System.out.println("Student deleted successfully!");

                        deleted = true;
                        break;
                    }
                }

                if (!deleted) {
                    System.out.println("Student not found.");
                }

                break;

            case 6:

                System.out.println("Thank you!");
                sc.close();
                return;

            default:

                System.out.println("Invalid choice.");
            }
        }
    }
}