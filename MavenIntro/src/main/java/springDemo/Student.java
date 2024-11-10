package springDemo;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Student {
    private String name;
    private int id;
    private Address address;

    private void initMethod()
    {
        System.out.println("I am inside init");
    }
    private void destroyMethod()
    {
        System.out.println("I am inside destroy");
    }

//    public Student(String name, int id, Address address) {
//        this.name = name;
//        this.id = id;
//        this.address = address;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }
//
//    public Student()
//    {
//
//    }

//    @Override
//    public String toString() {
//        return "Student{" +
//                "name='" + name + '\'' +
//                ", id=" + id +
//                ", address=" + address +
//                '}';
//    }
}
