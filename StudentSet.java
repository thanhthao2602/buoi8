
package buoi8_vn;

import java.util.*;


public class StudentSet extends StudentArray{
    private Comparator<Student> comparator;

    public StudentSet() {
        super();
        this.comparator = Comparator.comparingDouble(Student::getGpa);
    }
    
    public StudentSet(Comparator<Student> comparator) {
        this.comparator = comparator;
    }

    public StudentSet(Comparator<Student> comparator, List<Student> data) {
        super(data);
        this.comparator = comparator;
    }

    public Comparator<Student> getComparator() {
        return comparator;
    }

    public void setComparator(Comparator<Student> comparator) {
        this.comparator = comparator;
        data.sort(comparator);
    }

    public List<Student> getData() {
        return data;
    }

    public void setData(List<Student> data) {
        this.data = data;
    }
    public void insert(Student x){
        data.add(x);
        data.sort(comparator);
    }
    public void remove(Student x){
        data.remove(x);
        data.sort(comparator);
    }
    public boolean contain(Student x){
        return data.contains(x);
    }
     public void sort(StdComparator comparator) {
        data.sort((o1, o2) -> comparator.compare(o1, o2));
    }

    public void demoData(){
        data.add(new Student(123,"X",18, "HN",3.25)) ;
        data.add(new Student(122,"Y" ,19,"Hai Duong",3.9)) ;
        data.add(new Student(111 ,"Z",23, "Bac Ninh" , 3.3)) ;
        data.add(new Student(101 ,"T",23, "TH" , 3.5)) ;
        data.add(new Student(222 ,"K",19, "Bac Giang" ,3)) ;
    }
}
