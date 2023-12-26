
package buoi8_vn;

import java.util.*;
public class Student {
    private int id ; 
    private String name;
    private int age ;
    private String address;
    private double gpa;

    public Student(int id, String name, int age, String address, double gpa) {
        this.id = id;
        id++;
        this.name = name;
        this.age = age;
        this.address = address;
        this.gpa = gpa;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    public void nhap(){
        Scanner s = new Scanner(System.in);
        System.out.println("Nhap id :");
        id = s.nextInt();
        System.out.println("Nhap ten: ");
        name = s.nextLine();
        System.out.println("Nhap tuoi:");
        age = s.nextInt();
        System.out.println("Nhap dia chi : ");
        address = s.nextLine();
        System.out.println("Nhap gpa : ");
        gpa = s.nextDouble();
    }

//    @Override
//    public String toString() {
//        return "Student{" + "id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + ", gpa=" + gpa + '}';
//    }
    
}
