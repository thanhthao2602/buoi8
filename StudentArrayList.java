
package buoi8_vn;

import java.util.*;
public class StudentArrayList extends StudentArray{

    public StudentArrayList() {
    }
    public void add(Student x){
        data.add(x);
    }
    public void delete(Student x){
        data.remove(x);
    }
    public void sort(Comparator<Student> comparator){
        Collections.sort(data,comparator);
    }
}
