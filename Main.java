
package buoi8_vn;

import java.util.*;
public class Main {
  static StudentSet studentSet = new StudentSet();
    static List<Student> students = studentSet.getData();
    static Scanner sc = new Scanner(System.in);

    public static void addNewStudent() {
        Student student = new Student();
        sc.nextLine();
        student.nhap();
        studentSet.insert(student);
    }

    public static void removeOneStudentByID() {
        System.out.print("Input student ID: ");
        int id = sc.nextInt();
        for (Student st : studentSet.data) {
            if (st.getId() == id) {
                studentSet.remove(st);
                System.out.println("-> Delete successful!..");
            }
        }
    }

    public static void displayListStudents() {
        if (students.isEmpty()) {
            System.out.println("\n-> No students to display");
        } else {
            System.out.println("\n-> List of students: ");
            System.out.println("----------------------------------------");
            System.out.printf("%-20s %-40s %-20s %-20s %-20s\n" , "ID" , "Name" , "Age" , "Address" , "Gpa");
            for (Student student : students) {
                displayStudentInfo(student);
            }
        }
    }

    public static void displayStudentInfo(Student student) {
        System.out.printf("%-20s %-40s %-20s %-20s %-20s\n"
                , student.getId() , student.getName() , student.getAge() , student.getAddress() , student.getGpa());
    }

    public static void findStudentByName() {
        sc.nextLine();
        System.out.print("Input student name: ");
        String findName = sc.nextLine();
        System.out.printf("%-20s %-40s %-20s %-20s %-20s\n" , "ID" , "Name" , "Age" , "Address" , "Gpa");
        for (Student student : students) {
            if (student.getName().equals(findName)) {
                displayStudentInfo(student);
            }
        }
    }

    public static void sortByAge() {
        StdComparator ageComparator = (s1, s2) -> Integer.compare(s1.getAge(), s2.getAge());
        studentSet.sort(ageComparator);
        System.out.println("\n-> Students sorted by age: ");
        displayListStudents();
    }

    public static void sortByGPA() {
        StdComparator gpaComparator = (s1, s2) -> Double.compare(s1.getGpa(), s2.getGpa());
        studentSet.sort(gpaComparator);
        System.out.println("\n-> Students sorted by GPA: ");
        displayListStudents();
    }

    public static void sortStudentsByAgeThenGpa() {
        StdComparator ageThenGpaComparator = (s1, s2) -> {
            if (s1.getAge() != s2.getAge()) {
                return Integer.compare(s1.getAge(), s2.getAge());
            } else {
                return Double.compare(s1.getGpa(), s2.getGpa());
            }
        };
        studentSet.sort(ageThenGpaComparator);
        System.out.println("\n-> Students sorted by age then GPA.");
        displayListStudents();
    }

    public static void sort5() {
        StdComparator sortFive = (s1, s2) -> {
            if (s1.getAge()%2 ==0 && s2.getGpa()%2 != 0) {
                return -1 ;
            } else if (s1.getAge() %2 != 0 && s2.getAge() %2 ==0) {
                return 1;
            } else if (s1.getAge() %2 ==0 && s2.getAge() %2 == 0) {
                return s1.getAge() - s2.getAge() > 0 ? 1 : (s1.getAge() - s2.getAge() == 0) ? Double.compare(s1.getGpa(), s2.getGpa()) : -1;
            } else
                return s2.getAge() - s1.getAge() > 0 ? 1 : (s1.getAge() - s2.getAge() == 0) ? Double.compare(s1.getGpa(), s2.getGpa()) : -1;

        };
    }
    public static void main(String[] args) {
        studentSet.demoData();
        int choice;
        do {
            System.out.println("=============MENU==============");
            System.out.println("1. Add new student");
            System.out.println("2. Remove student ");
            System.out.println("3. Display list students ");
            System.out.println("4. Find student by name");
            System.out.println("5. Sort list students ");
            System.out.println("6. Exit...");
            System.out.println("----------------------------------------");
            System.out.print("Input your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addNewStudent();
                    break;
                case 2:
                    removeOneStudentByID();
                    break;
                case 3:
                    displayListStudents();
                    break;
                case 4:
                    findStudentByName();
                    break;
                case 5:
                    System.out.println("1. Sort by Age");
                    System.out.println("2. Sort by GPA");
                    System.out.println("3. Sort by Age Asc, GPA Desc with Age same");
                    System.out.println("4. Sort by Age Even before Age odd, Even Age Asc, Odd Age Desc, Same Age Asc");
                    System.out.print("Your choice: ");
                    int miniChoice = sc.nextInt();
                    if (miniChoice == 1) {
                        sortByAge();
                    }
                    else if (miniChoice == 2) {
                        sortByGPA();
                    }
                    else if (miniChoice == 3) {
                        sortStudentsByAgeThenGpa();
                    }
                    else if (miniChoice == 4) {
                        sort5();;
                    }
                    break;
                case 6: return ;
                default:
                    System.out.println("Input from 1 to 6");
                    break;
            }
        } while (choice != 0);
    }   
}
