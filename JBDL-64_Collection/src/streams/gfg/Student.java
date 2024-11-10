package streams.gfg;

import java.io.*;

public class Student implements Serializable { //it provides you extra check with it
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void writeObject() throws IOException{
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Sourav\\IdeaProjects\\JBDL-64_Collection\\src\\streams\\gfg\\demo.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        Student s = new Student("name",3);
        String a= "abc";

//        fileOutputStream.write(a.getBytes());
        objectOutputStream.writeObject(s);
    }
    public static Object readObject() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Sourav\\IdeaProjects\\JBDL-64_Collection\\src\\streams\\gfg\\demo.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        return objectInputStream.readObject();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//       writeObject();
        System.out.println(readObject());
    }
}

